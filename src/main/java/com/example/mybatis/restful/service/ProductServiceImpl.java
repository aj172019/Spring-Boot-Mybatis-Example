package com.example.mybatis.restful.service;

import com.example.mybatis.restful.dto.ProductRequest;
import com.example.mybatis.restful.dto.ProductResponse;
import com.example.mybatis.restful.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;

//ProductMapper를 통해서 실제 데이터베이스와 상호작용하며 CRUD 작업을 수행 -> RESTful API에서 Product 관리와 관련된 요청을 처리 할 수 있다.
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    // ProductMapper 의존성 주입 -> ProductMapper 객체를 사용하여 데이터베이스와 상호작용을 수행
    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    // Product 추가하는 메서드
    // 파라미터로 받은 ProductResponse 객체를 ProductMapper를 사용하여 데이터베이스에 상품을 추가
    @Override
    public ProductResponse createProduct(ProductResponse productResponse) {
        productMapper.insertProduct(productResponse);
        return productResponse;
    }

    // 모든 Product 리스트를 가져오는 메서드
    // ProductMapper를 사용하여 데이터베이스에서 모든 상품 정보를 조회
    @Override
    public List<ProductResponse> getAllProducts() {
        return productMapper.getAllProducts();
    }

    // 주어진 ID에 해당하는 Product 가져오는 메서드
    // ProductMapper를 사용하여 데이터베이스에서 주어진 ID에 해당하는 상품을 조회
    @Override
    public ProductResponse getProductById(Long id) {
        return productMapper.getProductById(id);
    }


    // 주어진 ID에 해당하는 Product를 수정하는 메서드
    // 데이터베이스에서 주어진 ID에 해당하는 상품을 업데이트
    @Override
    public ProductRequest updateProduct(Long id, ProductRequest productDTO) {
        productDTO.setId(id);
        productMapper.updateProduct(productDTO);
        return productDTO;
    }

    // 주어진 ID에 해당하는 Product를 삭제하는 메서드
    // ProductMapper를 사용하여 주어진 ID에 해당하는 상품을 삭제
    @Override
    public void deleteProduct(Long id) {
        productMapper.deleteProduct(id);
    }


}
