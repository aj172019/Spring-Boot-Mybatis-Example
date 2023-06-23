package com.example.mybatis.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
             AuthenticationException authException) throws IOException, ServletException {
        String url = request.getRequestURI();
        //response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        System.out.println("CustomAuthenticationEntryPoint  :::   " + authException);
        request.setAttribute("msg","권한이 없는 사용자 입니다. 로그인 해주세요.");
        request.setAttribute("nextPage","/login");
        request.getRequestDispatcher("/error/security_error").forward(request, response);
    }
}