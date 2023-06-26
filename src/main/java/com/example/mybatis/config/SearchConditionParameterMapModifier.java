package com.example.mybatis.config;

import javax.servlet.http.HttpServletRequest;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SearchConditionParameterMapModifier {
    private final Map<String, Object> parameterMap;

    protected SearchConditionParameterMapModifier(HttpServletRequest request) {
        this.parameterMap = new HashMap<>(request.getParameterMap()).entrySet().stream().map(e -> {
            Object value;
            if (e.getValue().length == 1) {
                value = e.getValue()[0];
            } else if (e.getValue().length < 1){
                value = null;
            } else {
                value = List.of(e.getValue());
            }
            return new AbstractMap.SimpleEntry<>(e.getKey(), value);
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public SearchConditionParameterMapModifier fromDate(String... fromDateFields) {
        for (String field : fromDateFields) {
            parameterMap.put(field, parameterMap.get("fromDate") + " 00:00:00");
        }
        return this;
    }

    public SearchConditionParameterMapModifier toDate(String... toDateFields) {
        for (String field : toDateFields) {
            parameterMap.put(field, parameterMap.get("toDate") + " 23:59:59");
        }
        return this;
    }

    public Map<String, Object> getParameterMap() {
        return parameterMap;
    }
}
