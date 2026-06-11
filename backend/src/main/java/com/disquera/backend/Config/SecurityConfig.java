package com.disquera.backend.Config;

import java.util.List;

import org.springframework.context.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import com.disquera.backend.Security.JwtAuthFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final JwtAuthFilter auth;

    public SecurityConfig (JwtAuthFilter auth){
        this.auth=auth;
    }

    @Bean
    public SecurityFilterChain seguridad(HttpSecurity http) throws Exception{
        http.addFilterBefore(auth, UsernamePasswordAuthenticationFilter.class);
        http.headers(headers->headers.frameOptions(frame->frame.disable()));
        http.csrf(csrf->csrf.disable());
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.cors(cors -> cors.configurationSource(request -> { CorsConfiguration config = new CorsConfiguration(); config.setAllowedOrigins(List.of("http://localhost:4200")); config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE")); config.setAllowedHeaders(List.of("*")); return config; }));
        return http.authorizeHttpRequests(auth -> auth.requestMatchers("/api/usuarioscomunes/**","/api/canciones/**", "/api/artistas/**", "/api/usuarios/crear", "/api/login", "/h2-console/**").permitAll().anyRequest().authenticated()).build();
    }

    @Bean
    public AuthenticationManager authManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }   
}