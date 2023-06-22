package com.example.mybatis.restful.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {

    private Long id;        // 상품의 ID
    private String name;    // 상품의 이름
    private String description; // 상품의 설명
    private double price;   // 상품의 가격

}

