package com.example.mybatis.member_detail.mapper;

import com.example.mybatis.member.dto.LoginRequest;
import com.example.mybatis.member.dto.LoginResponse;
import com.example.mybatis.member_detail.dto.LoadUserResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AuthDetailMapper {
    LoginResponse selectMemberByUserNameAndPassword(LoginRequest loginRequest);
    LoadUserResponse selectMemberByUserName(String username);
}
