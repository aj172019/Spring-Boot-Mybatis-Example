package com.example.mybatis.restful.controller;

import com.example.mybatis.restful.dto.ProductResponse;
import com.example.mybatis.restful.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    // ProductService를 주입받음
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // @PostMapping 어노테이션을 사용하여 "/create" 경로에 대한 POST 요청을 처리
    // ProductService의 createProduct 메서드를 호출하여 제품을 생성하고, 생성된 제품 응답을 반환
    @PostMapping("/create")
    public ProductResponse createProduct(@RequestBody ProductResponse productResponse) {
        return productService.createProduct(productResponse);
    }


}
