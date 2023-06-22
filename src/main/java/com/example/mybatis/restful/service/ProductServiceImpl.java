package com.example.mybatis.restful.service;

import com.example.mybatis.restful.dto.ProductResponse;
import com.example.mybatis.restful.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    // ProductMapper 의존성 주입
    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    // Product 추가하는 메서드
    @Override
    public ProductResponse createProduct(ProductResponse productResponse) {
        productMapper.insertProduct(productResponse);
        return productResponse;
    }

    // 모든 Product 리스트를 가져오는 메서드
    @Override
    public List<ProductResponse> getAllProducts() {
        return productMapper.getAllProducts();
    }

    // 주어진 ID에 해당하는 Product 가져오는 메서드
    @Override
    public ProductResponse getProductById(Long id) {
        return productMapper.getProductById(id);
    }


}
