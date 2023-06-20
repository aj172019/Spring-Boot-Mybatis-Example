package com.example.mybatis.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SaveMemberRequest {
    private String username;
    private String password;
    private String enabled;

    @Builder
    protected SaveMemberRequest(String username, String password, String enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }
}
