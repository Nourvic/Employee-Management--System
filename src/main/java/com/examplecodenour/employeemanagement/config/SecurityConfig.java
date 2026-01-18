package com.examplecodenour.employeemanagement.config;

import com.examplecodenour.employeemanagement.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private AuthService authService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    // Bean injection for Methods min. 1Methode
    // Services we use it to inject it into Clases
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors(AbstractHttpConfigurer::disable).csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(auth -> {
            //aut.anyRequest().permitAll() -> alle Endpoints sind freigegeben
            //  auth.anyRequest().permitAll();
            auth.requestMatchers("/auth/signup", "/employees").permitAll();
        });
        return http.build();
    }


    @Bean
    AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        var authBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authBuilder.userDetailsService(authService).passwordEncoder(passwordEncoder());

        return authBuilder.build();
    }
}
