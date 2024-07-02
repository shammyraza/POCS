package com.lcwd.user.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {

        security
                .csrf().disable() // Disable CSRF for simplicity, enable it in production
                .authorizeRequests()
                .antMatchers("/**").permitAll() // Allow unrestricted access to all URLs under /public/**
                .anyRequest().authenticated() // Require authentication for all other URLs
                .and()
                .httpBasic(); // Use basic authentication
        return security.build();

//        security.authorizeHttpRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .oauth2ResourceServer()
//                .jwt();
//        return security.build();

    }

}
