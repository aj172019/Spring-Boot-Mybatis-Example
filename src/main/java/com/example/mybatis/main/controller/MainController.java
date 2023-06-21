package com.example.mybatis.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    ///초기페이지
    @RequestMapping("/")
    public String index() {
        System.out.println("hello index!");

        return "index";
    }


    ///로그인페이지
    @RequestMapping("/login")
    public String login() {
        System.out.println("hello login!");

        return "pages/login";
    }

    ///회원가입 페이지
    @RequestMapping("/join")
    public String join() {
        System.out.println("hello join!");

        return "pages/join";
    }
}
