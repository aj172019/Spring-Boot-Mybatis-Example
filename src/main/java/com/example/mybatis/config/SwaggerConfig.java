package com.example.mybatis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// @Configuration를 사용하여 구성 파일임을 타내내고 @EnableSwagger2를 사용하여 Swagger를 활성화함 -> Swagger 관련 기능이 사용 가능해짐
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // @Bean을 사용하여 api() 메서드가 스프링 빈으로 등록되도록 지정
    // api() 메서드는 Docket 객체를 반환하는 메서드 , Swageer를 설정하기 위한 주요 인터페이스 -> Swagger가 API 컨트롤러의 주석과 주어진 패키지 내의 경로를 분석하여 API 문서를 생성함.
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.mybatis.restful.controller"))
                .paths(PathSelectors.any())
                .build();
    }

}
