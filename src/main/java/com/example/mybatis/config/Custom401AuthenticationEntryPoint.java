package com.example.mybatis.config;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.util.Assert;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Custom401AuthenticationEntryPoint implements AuthenticationEntryPoint {
    private final HttpStatus httpStatus;
    private final Object responseBody;

    public Custom401AuthenticationEntryPoint(Object responseBody) {
        Assert.notNull(responseBody, "401 : responseBody cannot be null");
        this.httpStatus = HttpStatus.UNAUTHORIZED;
        this.responseBody = responseBody;
    }

    @Override
    public final void commence(HttpServletRequest request, HttpServletResponse response,
                               AuthenticationException authException) throws IOException, ServletException {
        System.out.println("Custom401AuthenticationEntryPoint  :::   " + authException);
        request.setAttribute("msg","401 : 권한이 없는 사용자 입니다.");
        request.setAttribute("nextPage","/login");
        request.getRequestDispatcher("/error/401").forward(request, response);
    }
}