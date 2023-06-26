package com.example.mybatis.restful.mapper;

import com.example.mybatis.restful.dto.ProductRequest;
import com.example.mybatis.restful.dto.ProductResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/*Product Entity와 상호작용하기 위한 데이터베이스 Mapepr인 ProductMapper 인터페이스
Mybatis 프레임워크를 사용하여 SQL 쿼리를 실행하여 데이터베이스와 상호작용.*/

// Spring의 @Repository를 사용허여 repository의 컴포넌트로서 역할을 수행하여 이를 데이터베이스와 상호작용을 쉽게 수행 가능
// MyBatis의 @Mapper를 사용하여 Mapper로 등록
@Repository
@Mapper
public interface ProductMapper {

    // 제품을 추가하는 메서드
    // ProductResponse 객체를 데이터베이스에 추가
    void insertProduct(ProductResponse productResponse);

    // 모든 제품 리스트를 가져오는 메서드
    // 데이터베이스에서 모든 제품 정보를 조회
    List<ProductResponse> getAllProducts();

    // 주어진 ID에 해당하는 제품을 가져오는 메서드
    // 데이터베이스에서 주어진 ID에 해당하는 제품 정보를 조회
    ProductResponse getProductById(Long id);

    // 주어진 ID에 해당하는 제품을 수정하는 메서드
    // 데이터베이스에서 주어진 ID에 해당하는 제품 정보를 수정
    void updateProduct(ProductRequest productRequest);

    // 주어진 ID에 해당하는 제품을 삭제하는 메서드
    // 데이터베이스에서 주어진 ID에 해당하는 제품을 삭제
    void deleteProduct(Long id);

}
