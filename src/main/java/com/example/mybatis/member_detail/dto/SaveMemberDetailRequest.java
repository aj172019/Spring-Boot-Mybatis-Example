package com.example.mybatis.member_detail.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class SaveMemberDetailRequest {

    @NotNull
//    @UniqueElements
    private String username;

    @NotNull
    private String password;

    private String firstname;

    private String lastname;

    @NotNull
    private String phone;
    private String job;

    @NotNull
    private String role;

//    @NotNull
//    private String enabled;

    @Builder
    protected SaveMemberDetailRequest(String username, String password,
                                      String firstname, String lastname, String phone, String job,
                                      String role) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.job = job;
        this.role = role;
//        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "user:"+username+
                ",\n password"+password+
                ",\n firstname"+firstname+
                ",\n lastname"+lastname+
                ",\n phone"+phone+
                ",\n job"+job+
                ",\n role"+role+""
//                ",\n enabled"+enabled
                ;

    }
}
