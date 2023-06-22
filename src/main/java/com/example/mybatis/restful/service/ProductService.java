package com.example.mybatis.restful.service;

import com.example.mybatis.restful.dto.ProductRequest;
import com.example.mybatis.restful.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    // 상품을 추가하는 메서드
    ProductResponse createProduct(ProductResponse productResponse);

    // 살품의 리스트를 조회하는 메서드
    List<ProductResponse> getAllProducts();

    // ID를 기반으로 상품을 조회하는 메서드
    ProductResponse getProductById(Long id);

    // ID를 기반으로 상품을 수정하는 메서드
    ProductRequest updateProduct(Long id, ProductRequest productRequest);


}
