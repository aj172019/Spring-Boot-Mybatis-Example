package com.example.mybatis.restful.service;

import com.example.mybatis.restful.dto.ProductResponse;
import com.example.mybatis.restful.mapper.ProductMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    // ProductMapper 의존성 주입
    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    // ProductMapper를 사용하여 제품을 추가
    @Override
    public ProductResponse createProduct(ProductResponse productResponse) {
        productMapper.insertProduct(productResponse);
        return productResponse;
    }


}
