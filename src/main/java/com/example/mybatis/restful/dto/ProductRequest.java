package com.example.mybatis.restful.dto;

import lombok.Builder;

public class ProductRequest extends  ProductResponse {

    protected ProductRequest(Long id, String name, String description, double price) {
        super(id, name, description, price);
    }
}
