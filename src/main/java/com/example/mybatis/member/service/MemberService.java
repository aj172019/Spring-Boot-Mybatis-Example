package com.example.mybatis.member.service;

import com.example.mybatis.member.dto.*;
import org.springframework.stereotype.Service;

public interface MemberService {
    CreateMemberResponse createMember(SaveMemberRequest saveMemberRequest);
}
