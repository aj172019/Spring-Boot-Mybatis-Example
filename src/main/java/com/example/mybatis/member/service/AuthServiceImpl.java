package com.example.mybatis.member.service;

import com.example.mybatis.member.dto.LoginRequest;
import com.example.mybatis.member.dto.LoginResponse;
import com.example.mybatis.member.mapper.AuthMapper;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final AuthMapper authMapper;

    public AuthServiceImpl(AuthMapper authMapper) {
        this.authMapper = authMapper;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        return authMapper.selectMemberByUserNameAndPassword(loginRequest);
    }
}
