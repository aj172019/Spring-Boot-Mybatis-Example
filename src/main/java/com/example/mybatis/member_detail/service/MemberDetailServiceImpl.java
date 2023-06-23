package com.example.mybatis.member_detail.service;

import com.example.mybatis.member_detail.dto.CreateMemberResponse;
import com.example.mybatis.member_detail.dto.SaveMemberDetailRequest;
import com.example.mybatis.member_detail.mapper.MemberDetailMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberDetailServiceImpl implements MemberDetailService {

    private final MemberDetailMapper memberDetailMapper;

    public MemberDetailServiceImpl(MemberDetailMapper memberDetailMapper) {
        this.memberDetailMapper = memberDetailMapper;
    }

    @Override
    public CreateMemberResponse createMember(SaveMemberDetailRequest saveMemberRequest) {
        System.out.println("createMember");
        memberDetailMapper.insertMemberDetail(saveMemberRequest);
        return new CreateMemberResponse();
    }
}
