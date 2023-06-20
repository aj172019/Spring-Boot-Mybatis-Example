package com.example.mybatis.member.controller;

import com.example.mybatis.MockMvcControllerTest;
import com.example.mybatis.member.dto.CreateMemberResponse;
import com.example.mybatis.member.dto.SaveMemberRequest;
import com.example.mybatis.member.service.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = MemberController.class)
@DisplayName("MemberController API Request Test Case")
class MemberControllerTest extends MockMvcControllerTest {
    private static final String BASE_URL = "/api/member";
    @Autowired
    private MemberController controller;

    @MockBean
    private MemberService memberService;
    @MockBean
    private CreateMemberResponse createMemberResponse;

    @Override
    protected Object controller() {
        return this.controller;
    }

    @Test
    @DisplayName("Member Registration Request")
    void create() throws Exception {
        // given
        SaveMemberRequest saveMemberRequest =
                SaveMemberRequest.builder()
                        .username("안상구")
                        .password("1q2w3e!!")
                        .enabled("Y")
                        .build();
        given(memberService.createMember(any(SaveMemberRequest.class))).willReturn(this.createMemberResponse);

        mockMvc.perform(post(BASE_URL).contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(new ObjectMapper().writeValueAsString(saveMemberRequest)))
                .andDo(print())
                .andExpect(status().isOk());
    }
}