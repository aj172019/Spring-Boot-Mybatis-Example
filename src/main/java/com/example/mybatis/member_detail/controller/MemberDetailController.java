package com.example.mybatis.member_detail.controller;

import com.example.mybatis.member_detail.dto.CreateMemberResponse;
import com.example.mybatis.member_detail.dto.SaveMemberDetailRequest;
import com.example.mybatis.member_detail.service.MemberDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/member_detail")
public class MemberDetailController {

    private final MemberDetailService memberDetailService;
    private final PasswordEncoder passwordEncoder;

    public MemberDetailController(MemberDetailService memberDetailService,PasswordEncoder passwordEncoder) {
        this.memberDetailService = memberDetailService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping(value = "/join")
    public ResponseEntity<CreateMemberResponse> create(@RequestBody SaveMemberDetailRequest saveMemberRequest) {
        System.out.println("join requested");
        memberDetailService.createMember(saveMemberRequest);
        return ResponseEntity.ok().build();
    }
}
