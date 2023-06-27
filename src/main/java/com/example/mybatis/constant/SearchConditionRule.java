package com.example.mybatis.constant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

public enum SearchConditionRule {
    DATE_STRING_TO_LOCAL_DATE(field -> LocalDate.parse(field, DateTimeFormatter.ofPattern(DateTimeFormat.DATE.format))),
    DATE_TIME_STRING_TO_LOCAL_DATE_TIME(field -> LocalDateTime.parse(field, DateTimeFormatter.ofPattern(DateTimeFormat.DATE_TIME.format))),
    FROM_DATE_STRING_TO_LOCAL_DATE_TIME(field -> LocalDateTime.parse(field + " 00:00:00", DateTimeFormatter.ofPattern(DateTimeFormat.DATE_TIME.format))),
    TO_DATE_STRING_TO_LOCAL_DATE_TIME(field -> LocalDateTime.parse(field + " 23:59:59", DateTimeFormatter.ofPattern(DateTimeFormat.DATE_TIME.format)));

    private final Function<String, Object> formula;


    SearchConditionRule(Function<String, Object> formula) {
        this.formula = formula;
    }

    public Function<String, Object> formula() {
        return formula;
    }

    //nested class for DateTimeFormatter Constants
    private enum DateTimeFormat {
        DATE_TIME("yyyy-MM-dd HH:mm:ss"),
        DATE("yyyy-MM-dd");

        private final String format;

        DateTimeFormat(String format) {
            this.format = format;
        }
    }
}

