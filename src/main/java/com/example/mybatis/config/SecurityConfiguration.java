package com.example.mybatis.config;

import com.example.mybatis.member_detail.service.AuthDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.RequestCacheConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebSecurity      //Spring security 사용
public class SecurityConfiguration {
    private final AuthDetailService authDetailService;

    public SecurityConfiguration(AuthDetailService authDetailService) {
        this.authDetailService = authDetailService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        /// for swegger
        http .authorizeHttpRequests()
                .antMatchers("/api/products/**", "/swagger-ui/**", "/v3/api-docs", "/swagger-resources/**").permitAll()
                .and()
                .csrf().ignoringAntMatchers("/api/products/**");

        /// for front
        http.csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());

        http .authorizeHttpRequests()
                .antMatchers("/admin/**").hasAuthority("Admin")
                .antMatchers(HttpMethod.GET, "/login", "/join", "/*", "/api/first_token/").permitAll()
                .antMatchers(HttpMethod.POST,  "/api/vue/**", "/api/**").permitAll()
                .anyRequest().authenticated();

        http.exceptionHandling()
                .authenticationEntryPoint(new CustomAuthenticationEntryPoint())         //인증실패 : 로그인유도
                .accessDeniedHandler(new CustomAccessDeniedHandler())                   //인가실패 : 로그인은 했으나 권한없음
        ;

        http.httpBasic();

        ///미로그인 시 강제핸들링처리
//        Map<String, String> responseBody = new HashMap<>();
//        responseBody.put("error", "unauthorized");
//        http.exceptionHandling()
//                .authenticationEntryPoint(new Custom401AuthenticationEntryPoint(responseBody))
//                .accessDeniedHandler(new CustomAccessDeniedHandler());
        return http.build();
    }

    @Bean
    @Order(0)
    public SecurityFilterChain resourceFilterChain(HttpSecurity http) throws Exception {
        return http.requestMatchers(matchers -> matchers
                        .antMatchers("/css/**"))
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().permitAll())
                .requestCache(RequestCacheConfigurer::disable)
                .securityContext(AbstractHttpConfigurer::disable)
                .sessionManagement(AbstractHttpConfigurer::disable)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
