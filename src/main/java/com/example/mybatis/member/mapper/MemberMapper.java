package com.example.mybatis.member.mapper;

import com.example.mybatis.member.dto.MemberResponse;
import com.example.mybatis.member.dto.SaveMemberRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Mapper
public interface MemberMapper {
    Long insertMember(SaveMemberRequest saveMemberRequest);


}
