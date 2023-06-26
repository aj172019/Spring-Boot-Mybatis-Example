package com.example.mybatis.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Parameters {
    private final Map<String, Object> parameterMap;

    protected Parameters(HttpServletRequest request) {
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

    // modify parameterMap value by function
    public Parameters modify(String[] fields, Function<String, Object> function) {
        Arrays.stream(fields).forEach(field -> {
            if (parameterMap.containsKey(field)) {
                parameterMap.put(field, function.apply((String) parameterMap.get(field)));
            }
        });
        return this;
    }

    //retun object by parameter class type
    public <T> T map(Class<T> clazz) {
        return new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .convertValue(parameterMap, clazz);
    }
}
