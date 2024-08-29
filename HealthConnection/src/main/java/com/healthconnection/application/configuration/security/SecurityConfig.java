package com.healthconnection.application.configuration.security;

import com.healthconnection.application.configuration.security.filters.JwtAuthenticationFilter;
import com.healthconnection.application.configuration.security.service.CustomUserDetailsService;
import com.healthconnection.crosscutting.helper.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService userDetailsService;

    public SecurityConfig(JwtUtil jwtUtil, CustomUserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .authorizeHttpRequests(authorize ->
                authorize
                    .requestMatchers("/api/v1/auth/login").permitAll()
                    .requestMatchers("/api/v1/eps/consultar").permitAll()
                    .requestMatchers("/api/v1/identifications/consultar").permitAll()
                    .requestMatchers("/api/v1/affiliationregime/consultar").permitAll()
                    .requestMatchers("/api/v1/patients/register").permitAll()
                    .requestMatchers("/api/v1/professional/register").permitAll()
                    .requestMatchers("/api/v1/roles/consultar").permitAll()
                    .requestMatchers("/api/v1/services/consultar").permitAll()
                    .requestMatchers("/api/v1/cloudinary/upload").permitAll()
                    .requestMatchers("/api/v1/professional/consultar").permitAll()
                    .requestMatchers("/verify-email/**").permitAll()
                    .anyRequest().authenticated()
            )
            .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter(jwtUtil, userDetailsService);
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}


