package com.example.mybatis;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MybatisApplicationTests {
    @LocalServerPort
    int port;

    @BeforeEach
    void contextLoads() {
        RestAssured.port = port;
    }

}
