package com.example.mybatis.restful.mapper;

import com.example.mybatis.restful.dto.ProductRequest;
import com.example.mybatis.restful.dto.ProductResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductMapper {

    // 제품을 추가하는 메서드
    void insertProduct(ProductResponse productResponse);

    // 모든 제품 리스트를 가져오는 메서드
    List<ProductResponse> getAllProducts();

    // 주어진 ID에 해당하는 제품을 가져오는 메서드
    ProductResponse getProductById(Long id);

    // 주어진 ID에 해당하는 제품을 수정하는 메서드
    void updateProduct(ProductRequest productRequest);

    // 주어진 ID에 해당하는 제품을 삭제하는 메서드
    void deleteProduct(Long id);

}
