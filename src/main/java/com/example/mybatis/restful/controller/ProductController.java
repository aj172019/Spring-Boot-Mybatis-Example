package com.example.mybatis.restful.controller;

import com.example.mybatis.restful.dto.ProductRequest;
import com.example.mybatis.restful.dto.ProductResponse;
import com.example.mybatis.restful.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController , @RequestMapping을 사용하여 API의 엔드포인트를 처리하는 Controller를 나타내고 기본 경로를 설정

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    // ProductService를 주입 -> Contorller에서 Servive Method를 호출 할 수 있음
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // HTTP 요청 메서드에 대한 핸들러 메서드 -> 각 HTTP 요청 메서드 GET, POST, PUT, DELETE에 대해 해당하는 핸들러 메서드
    // @PostMapping 어노테이션을 사용하여 "/create" 경로에 대한 POST 요청을 처리
    // ProductService의 createProduct 메서드를 호출하여 제품을 생성하고, 생성된 제품 응답을 반환
    @PostMapping("/create")
    public ProductResponse createProduct(@RequestBody ProductResponse productResponse) {
        return productService.createProduct(productResponse);
    }


    // @GetMapping 어노테이션을 사용하여 "/api/get/products" 경로에 대한 GET 요청을 처리
    // ProductService의 getAllProducts 메서드를 호출하여 모든 제품 리스트를 반환
    @GetMapping("/get")
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }


    // @GetMapping 어노테이션을 사용하여 "/api/products/get/{id}" 경로에 대한 GET 요청을 처리
    // ProductService의 getProductById 메서드를 호출하여 주어진 ID에 해당하는 제품을 반환
    @GetMapping("/get/{id}")
    public ProductResponse getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }


    // @PutMapping 어노테이션을 사용하여 "/api/products/update/{id}" 경로에 대한 PUT 요청을 처리
    // @PathVariable 사용해서 id를 받아와 @RequestBody을 사용하여 요청 본문에서 ProductRequest를 받아옴
    // ProductService updateProduct 메서드를 호출하여 주어진 ID에 해당하는 제품을 업데이트하고, 업데이트된 제품 요청을 반환
    @PutMapping("/update/{id}")
    public ProductRequest updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
        return productService.updateProduct(id, productRequest);
    }


    // @DeleteMapping 어노테이션을 사용하여 "/api/products/delete/{id}" 경로에 대한 DELETE 요청을 처리
    // ProductService의 deleteProduct 메서드를 호출하여 주어진 ID에 해당하는 제품을 삭제하고, 삭제 완료 응답을 반환
    // noContent() -> status 204 (요청이 성공했지만 서버가 응답 본문에 데이터를 포함시키지 않는 경우)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    // HTTP status 200
   /*@DeleteMapping("/{id}")
      public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }*/


}
