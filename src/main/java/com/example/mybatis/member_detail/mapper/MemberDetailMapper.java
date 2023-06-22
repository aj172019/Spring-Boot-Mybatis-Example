package com.example.mybatis.member_detail.mapper;

import com.example.mybatis.member_detail.dto.SaveMemberDetailRequest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MemberDetailMapper {
    Long insertMemberDetail(SaveMemberDetailRequest saveMemberRequest);

    Long selectMemberDetailByEmail(String email);
    Long updateMemberDetail(SaveMemberDetailRequest saveMemberRequest);

    //Long updateMemberDetail(SaveMemberRequest saveMemberRequest);
}
