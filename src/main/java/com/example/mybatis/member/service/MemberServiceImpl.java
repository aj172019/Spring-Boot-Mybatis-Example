package com.example.mybatis.member.service;

import com.example.mybatis.member.dto.*;
import com.example.mybatis.member.mapper.MemberMapper;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;

    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public CreateMemberResponse createMember(SaveMemberRequest saveMemberRequest) {
        memberMapper.insertMember(saveMemberRequest);
        return new CreateMemberResponse();
    }
}
