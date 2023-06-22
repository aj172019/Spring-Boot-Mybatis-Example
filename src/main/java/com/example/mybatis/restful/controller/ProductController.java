package com.example.mybatis.restful.controller;

import com.example.mybatis.restful.dto.ProductResponse;
import com.example.mybatis.restful.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // @GetMapping 어노테이션을 사용하여 "/api/products" 경로에 대한 GET 요청을 처리
    // ProductService의 getAllProducts 메서드를 호출하여 모든 제품 리스트를 반환
    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    // @GetMapping 어노테이션을 사용하여 "/api/products/{id}" 경로에 대한 GET 요청을 처리
    // ProductService의 getProductById 메서드를 호출하여 주어진 ID에 해당하는 제품을 반환
    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
}
