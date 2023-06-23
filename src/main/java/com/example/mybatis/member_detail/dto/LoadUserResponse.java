package com.example.mybatis.member_detail.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoadUserResponse {
    private String username;
    private String password;
    private String role;
}
