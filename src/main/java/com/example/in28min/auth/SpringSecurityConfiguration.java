package com.example.in28min.auth;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

import static org.springframework.web.servlet.function.RequestPredicates.headers;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager createUserDetailsMaager(){
        UserDetails userDetails1 = createNewUser("in28minutes", "dummy");
        UserDetails userDetails2 = createNewUser("test1","1234");
        return new InMemoryUserDetailsManager(userDetails1,userDetails2);
    }

    private static UserDetails createNewUser(String userName, String password) {

        Function<String, String> passwordEncoder =
                input->passwordEncoder().encode(input);
        User.UserBuilder builder = User.builder();
        builder.passwordEncoder(passwordEncoder);
        builder.username(userName);
        builder.password(password);
        builder.roles("USER", "ADMIN");
        UserDetails userDetails = builder.build();
        return userDetails;
    }

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // Security를 초기설정만 했을 때 작동되는 기능
    // 1. 모든 URL 보호
    // 2. 비인가 이용자, 비인가주소 요청은 기본로그인 창으로 요청

    // H2 사용 시 CSRF 허용 Frames를 허용 해주어야함
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated())
                .formLogin(form -> form.defaultSuccessUrl("/",true))
                .csrf(csrf-> csrf.disable())
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));
        return http.build();
    }
}
