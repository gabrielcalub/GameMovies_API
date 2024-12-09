package com.Mynt.Movies.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                // Disable CSRF protection (required for the H2 console and for some APIs)
                .csrf(csrf -> csrf.disable())

                // Configure headers to allow iframe from the same origin (needed for H2 console)
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()))

                // Authorization rules
                .authorizeHttpRequests(auth -> {
                    // Allow access to H2 console and OAuth login
                    auth.antMatchers("/h2-console/**", "/login", "/error", "/home").permitAll();
                    // Require authentication for all other requests
                    auth.anyRequest().authenticated();
                })

                // Enable OAuth2 login (GitHub, Google, etc.)
                .oauth2Login(withDefaults())

                // Enable form-based login (optional fallback)
                .formLogin(withDefaults())

                // Build the Security Filter Chain
                .build();
    }
}
