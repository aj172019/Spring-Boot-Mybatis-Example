package com.example.mybatis.restful.service;

import com.example.mybatis.restful.dto.ProductResponse;

public interface ProductService {

    // 상품을 추가하는 메서드
    ProductResponse createProduct(ProductResponse productResponse);

}
