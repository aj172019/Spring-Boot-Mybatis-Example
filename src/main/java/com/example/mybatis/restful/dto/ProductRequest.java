package com.example.mybatis.restful.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest   {

    private Long id;        // 상품의 ID
    private String name;    // 상품의 이름
    private String description; // 상품의 설명
    private double price;   // 상품의 가격

    @Builder
    protected ProductRequest(Long id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
