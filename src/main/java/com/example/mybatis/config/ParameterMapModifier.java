package com.example.mybatis.config;

import com.example.mybatis.constant.SearchConditionRule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javax.servlet.http.HttpServletRequest;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ParameterMapModifier {
    private final Map<String, Object> parameterMap;

    public ParameterMapModifier(HttpServletRequest request) {
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

    //modify parameterMap value by ResovlerRule, string field
    public void modify(String field, SearchConditionRule rule) {
        modify(field, rule.formula());
    }
    //modify parameterMap value by function, string field
    public void modify(String field, Function<String, Object> function) {
        if (!parameterMap.containsKey(field)) {
            throw new IllegalArgumentException("field not found: " + field);
        }
        parameterMap.put(field, function.apply((String) parameterMap.get(field)));
    }

    //retun object by parameter class type
    public <T> T map(Class<T> clazz) {
        return new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .convertValue(parameterMap, clazz);
    }
}
