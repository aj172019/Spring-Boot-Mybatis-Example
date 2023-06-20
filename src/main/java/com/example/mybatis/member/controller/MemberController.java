package com.example.mybatis.member.controller;

import com.example.mybatis.member.dto.CreateMemberResponse;
import com.example.mybatis.member.dto.SaveMemberRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    @PostMapping
    public ResponseEntity<CreateMemberResponse> create(@Valid @RequestBody SaveMemberRequest saveMemberRequest) {

        return ResponseEntity.ok().build();
    }

}
