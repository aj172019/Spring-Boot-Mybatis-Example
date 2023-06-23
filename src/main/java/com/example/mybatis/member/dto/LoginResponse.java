package com.example.mybatis.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginResponse {
    private String username;

    public boolean Isvalid(){
        return !username.isEmpty();
    }
}
