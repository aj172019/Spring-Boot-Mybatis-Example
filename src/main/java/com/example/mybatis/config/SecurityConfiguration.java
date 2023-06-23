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

    ///Orginal
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic().disable().csrf().disable();

        return http.authorizeHttpRequests()
                .anyRequest().permitAll()
                .and()
                .build();
    }

    @Bean
    public SecurityFilterChain newSecurityFilterChain(HttpSecurity http) throws Exception {
        http .authorizeHttpRequests()
                .antMatchers("/api/**", "/swagger-ui/**", "/v3/api-docs", "/swagger-resources/**").permitAll()
                .antMatchers("/admin/**").hasAuthority("Admin")
                .antMatchers(HttpMethod.GET, "/login", "/join", "/*").permitAll()
                .antMatchers(HttpMethod.POST,  "/api/vue/**").permitAll()
                .antMatchers("/join").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/auth_detail/login")
                .defaultSuccessUrl("/")
                .usernameParameter("username")
                .failureUrl("/login/error")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/");


        http.exceptionHandling()
                .authenticationEntryPoint(new CustomAuthenticationEntryPoint())         //인증실패 : 로그인유도
                .accessDeniedHandler(new CustomAccessDeniedHandler())                   //인가실패 : 로그인은 했으나 권한없음
        //.accessDeniedPage("/members/login")
        ;

        ///미로그인 시 강제핸들링처리 2022-12-05
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("error", "unauthorized");
        http.exceptionHandling()
                .authenticationEntryPoint(new Custom401AuthenticationEntryPoint(HttpStatus.UNAUTHORIZED, responseBody))
                .accessDeniedHandler(new CustomAccessDeniedHandler());

                http.httpBasic().disable().csrf().disable();
//        http.csrf().csrfTokenRepository(new HttpSessionCsrfTokenRepository());

       /* http    // CSRF Token
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
*/
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
