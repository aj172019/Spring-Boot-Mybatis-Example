package com.example.mybatis.member_detail.service;

import com.example.mybatis.member.dto.LoginRequest;
import com.example.mybatis.member.dto.LoginResponse;

public interface AuthDetailService {
    LoginResponse login(LoginRequest loginRequest);
}
