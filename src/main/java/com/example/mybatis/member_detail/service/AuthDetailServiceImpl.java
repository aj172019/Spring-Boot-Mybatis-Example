package com.example.mybatis.member_detail.service;

import com.example.mybatis.member.dto.LoginRequest;
import com.example.mybatis.member.dto.LoginResponse;
import com.example.mybatis.member_detail.dto.LoadUserResponse;
import com.example.mybatis.member_detail.mapper.AuthDetailMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthDetailServiceImpl implements AuthDetailService, UserDetailsService {
    private final AuthDetailMapper authDetailMapper;

    public AuthDetailServiceImpl(AuthDetailMapper authDetailMapper) {
        this.authDetailMapper = authDetailMapper;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        System.out.println("login");

        return authDetailMapper.selectMemberByUserNameAndPassword(loginRequest);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername");
        LoadUserResponse loginInfo = authDetailMapper.selectMemberByUserName(username);

        if (loginInfo == null) {
            throw new UsernameNotFoundException(username);
        }

        return User.builder()
                .username(loginInfo.getUsername())
                .password(loginInfo.getPassword())
                .roles(loginInfo.getRole().toString())
                .build();
    }
}
