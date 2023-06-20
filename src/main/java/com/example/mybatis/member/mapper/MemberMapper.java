package com.example.mybatis.member.mapper;

import com.example.mybatis.member.dto.MemberResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Mapper
public interface MemberMapper {

    Optional<MemberResponse> selectMemberByUserName(String username);

    Optional<MemberResponse> selectMemberByUserNameAndPassword(@Param("username") String username, @Param("password") String password);

}
