package com.example.in28min.auth;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.function.Function;

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
}
