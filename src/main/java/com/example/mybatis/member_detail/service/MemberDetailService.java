package com.example.mybatis.member_detail.service;

import com.example.mybatis.member_detail.dto.CreateMemberResponse;
import com.example.mybatis.member_detail.dto.SaveMemberDetailRequest;

public interface MemberDetailService {
    CreateMemberResponse createMember(SaveMemberDetailRequest saveMemberRequest);
}
