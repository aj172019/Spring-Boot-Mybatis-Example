package com.example.mybatis.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberResponse {
    private String username;

    protected MemberResponse(String username) {
        this.username = username;
    }
}
