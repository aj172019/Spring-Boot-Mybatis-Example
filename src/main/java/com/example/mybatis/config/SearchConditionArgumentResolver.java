package com.example.mybatis.config;

import com.example.mybatis.config.annotation.SearchCondition;
import com.example.mybatis.constant.ResolverRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

@Slf4j
public class SearchConditionArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        Method method = Objects.requireNonNull(parameter.getMethod());
        if (method.getAnnotation(GetMapping.class) == null) {
            throw new IllegalArgumentException("SearchCondition only supports GET method");
        }
        return parameter.getParameterAnnotation(SearchCondition.class) != null;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        SearchCondition searchCondition = Objects.requireNonNull(parameter.getParameterAnnotation(SearchCondition.class));
        ParameterMapModifier parameterMapModifier = new ParameterMapModifier(request);
        Arrays.stream(searchCondition.fromDateFields())
                .forEach(field -> parameterMapModifier.modify(field, ResolverRule.FROM_DATE_STRING_TO_LOCAL_DATE_TIME));
        Arrays.stream(searchCondition.toDateFields())
                .forEach(field -> parameterMapModifier.modify(field, ResolverRule.TO_DATE_STRING_TO_LOCAL_DATE_TIME));
        return parameterMapModifier.map(parameter.getParameterType());
    }
}
