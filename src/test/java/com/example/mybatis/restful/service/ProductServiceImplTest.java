package com.example.mybatis.restful.service;


import com.example.mybatis.restful.dto.ProductRequest;
import com.example.mybatis.restful.dto.ProductResponse;
import com.example.mybatis.restful.mapper.ProductMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductServiceImplTest {

    // ProductMapper Mock 객체
    @Mock
    private ProductMapper productMapper;

    // 테스트할 ProductService 객체
    private ProductService productService;

    // MockitoAnnotations 사용하여 Mock 객체 초기화
    // productservice 객체 초기화
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        productService = new ProductServiceImpl(productMapper);
    }


    // createProduct Method Test
    @Test
    void createProductTest() {

        // Given
        // 특정 값을 가진 ProductResponse 객체를 생성
        ProductResponse productResponse = ProductResponse.builder()
                .id(1L)
                .name("desk")
                .description("This is a desk")
                .price(2000)
                .build();

        // productResponse 객체의 ID, 이름, 설명, 가격을 출력
        System.out.println("ID: " + productResponse.getId());
        System.out.println("Name: " + productResponse.getName());
        System.out.println("Description: " + productResponse.getDescription());
        System.out.println("Price: " + productResponse.getPrice());


        // When
        // productService의 createProduct 메서드를 호출
        productService.createProduct(productResponse);

        // Then
        // productMapper의 insertProduct 메서드가 productResponse 객체와 함께 한 번 호출되는지 확인
        verify(productMapper, times(1)).insertProduct(productResponse);
    }


    // getAllProducts Method Test
    @Test
    void getAllProductsTest() {

        // Given
        // 빈 ProductList 생성
        List<ProductResponse> productList = new ArrayList<>();

        // ProductResponse 객체 두 개를 productList에 추가
        productList.add(ProductResponse.builder().build());
        productList.add(ProductResponse.builder().build());

        // productMapper.getAllProducts() 호출 시 productList 반환하도록 설정
        when(productMapper.getAllProducts()).thenReturn(productList);

        // When
        // productService.getAllProducts() 호출
        List<ProductResponse> result = productService.getAllProducts();

        // Then
        // productMapper.getAllProducts()가 한 번 호출되는지 확인
        verify(productMapper, times(1)).getAllProducts();

        // result 리스트의 크기가 2인지 출력
        assertEquals(2, result.size());


        System.out.println("Product List:");
        for (ProductResponse product : result) {
            System.out.println("ID: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println("Description: " + product.getDescription());
            System.out.println("Price: " + product.getPrice());
            System.out.println("------------------");
        }
    }

    // getProductById Method Test
    @Test
    void getProductByIdTest() {
        // Given
        // ProductResponse 객체 생성
        Long productId = 1L;
        ProductResponse productResponse = ProductResponse.builder()
                .id(productId)
                .name("desk")
                .description("THis is a desk")
                .price(200)
                .build();

        // productMapper.getProductById(productId) 호출 시 productResponse 반환하도록 설정
        when(productMapper.getProductById(productId)).thenReturn(productResponse);

        // When
        // productService.getProductById(productId) 호출
        ProductResponse result = productService.getProductById(productId);

        // Then
        // productMapper.getProductById(productId)가 한 번 호출되는 지 확인
        verify(productMapper, times(1)).getProductById(productId);
        assertEquals(productId, result.getId());
        assertEquals("desk", result.getName());
        assertEquals("THis is a desk", result.getDescription());
        assertEquals(200, result.getPrice());

        System.out.println("Product Information:");
        System.out.println("ID: " + result.getId());
        System.out.println("Name: " + result.getName());
        System.out.println("Description: " + result.getDescription());
        System.out.println("Price: " + result.getPrice());
    }


    // deleteProduct Mwthod Test
    @Test
    void deleteProductTest() {

        // Given
        Long productId = 1L;

        // When
        // productService.deleteProduct(productID) 호출
        productService.deleteProduct(productId);

        // Then
        // ProductMapper.deleteProduct(productId)가 한 번 호출되는 지 확인
        verify(productMapper, times(1)).deleteProduct(productId);

        System.out.println("Product ID:" + productId + " 삭제");
    }
}



