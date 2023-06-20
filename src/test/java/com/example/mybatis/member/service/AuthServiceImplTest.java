package com.example.mybatis.member.service;

import com.example.mybatis.member.dto.LoginRequest;
import com.example.mybatis.member.dto.LoginResponse;
import com.example.mybatis.member.mapper.AuthMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@DisplayName("AuthServiceImpl Test")
class AuthServiceImplTest {
    @InjectMocks
    private AuthServiceImpl authService;
    @Mock
    private AuthMapper authMapper;
    @Mock
    private LoginRequest mockLoginRequest;
    @Mock
    private LoginResponse mockLoginResponse;


    @Test
    @DisplayName("Login")
    void login() {
        // given
        given(mockLoginRequest.getUsername()).willReturn("신은숙");
        given(mockLoginRequest.getPassword()).willReturn("1q2w3e!!");
        given(authMapper.selectMemberByUserNameAndPassword(any(LoginRequest.class))).willReturn(mockLoginResponse);
        given(mockLoginResponse.getUsername()).willReturn("신은숙");

    }
}