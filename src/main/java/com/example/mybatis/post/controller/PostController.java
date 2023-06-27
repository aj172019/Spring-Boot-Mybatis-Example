package com.example.mybatis.post.controller;


import com.example.mybatis.annotation.SearchCondition;
import com.example.mybatis.post.dto.PostSearchCondition;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @GetMapping
    public ResponseEntity<HttpStatus> getPost(
            @SearchCondition(
                    fromDateFields = {"fromDate"},
                    toDateFields = {"toDate"})
                    PostSearchCondition postSearchCondition) {
        return ResponseEntity.ok().build();
    }
}
