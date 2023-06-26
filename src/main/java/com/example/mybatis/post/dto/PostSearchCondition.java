package com.example.mybatis.post.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostSearchCondition {
//    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fromDate;
//    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime toDate;
    private String title;
    private String content;
    private String author;

    @Builder
    public PostSearchCondition(LocalDateTime fromDate, LocalDateTime toDate, String title, String content, String author) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
