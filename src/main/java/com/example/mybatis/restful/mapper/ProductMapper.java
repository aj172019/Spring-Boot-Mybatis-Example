package com.example.mybatis.restful.mapper;

import com.example.mybatis.restful.dto.ProductResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ProductMapper {

    // 제품을 추가하는 메서드
    void insertProduct(ProductResponse productResponse);
}
