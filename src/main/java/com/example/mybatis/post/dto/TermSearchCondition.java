package com.example.mybatis.post.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class TermSearchCondition {
    protected String fromDate;
    protected String toDate;
}
