package com.example.mybatis.member_detail.controller;

import com.example.mybatis.member.dto.LoginRequest;
import com.example.mybatis.member.dto.LoginResponse;
import com.example.mybatis.member_detail.service.AuthDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth_detail")
public class AuthDetailController {
    private final AuthDetailService authDetailService;

    public AuthDetailController(AuthDetailService authDetailService) {
        this.authDetailService = authDetailService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {

        LoginResponse loginInfo = authDetailService.login(loginRequest);

        if( loginInfo != null && loginInfo.Isvalid()){
            System.out.println("login ok");
            return ResponseEntity.ok(loginInfo);
        }
        System.out.println("login failed");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(loginInfo);
    }
}
