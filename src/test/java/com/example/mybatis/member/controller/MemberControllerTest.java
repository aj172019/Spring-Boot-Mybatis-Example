package com.example.mybatis.member.controller;

import com.example.mybatis.MockMvcControllerTest;
import com.example.mybatis.member.dto.CreateMemberResponse;
import com.example.mybatis.member.dto.SaveMemberRequest;
import com.example.mybatis.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = MemberController.class)
@DisplayName("MemberController API Request Test Case")
class MemberControllerTest extends MockMvcControllerTest {
    private static final String BASE_URL = "/api/member";
    private final MemberController controller;
    @MockBean
    private MemberService memberService;
    @MockBean
    private CreateMemberResponse createMemberResponse;

    @Autowired
    MemberControllerTest(MemberController controller) {
        this.controller = controller;
    }

    @Override
    protected Object controller() {
        return this.controller;
    }

    @Test
    @DisplayName("Member Registration Request")
    void create() throws Exception {
        given(memberService.createMember(any(SaveMemberRequest.class))).willReturn(this.createMemberResponse);

        mockMvc.perform(post(BASE_URL))
                .andDo(print())
                .andExpect(status().isOk());
    }
}