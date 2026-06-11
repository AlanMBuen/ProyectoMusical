package com.disquera.backend.Security;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtUtil util;
    public JwtAuthFilter(JwtUtil util){
        this.util=util;
    }

    @Override
    public void doFilterInternal(HttpServletRequest requerimiento, HttpServletResponse respuesta, FilterChain filtro)
    throws IOException, ServletException{

        if(requerimiento.getServletPath().equals("/api/login") ||
        requerimiento.getServletPath().equals("/api/usuario/crear") ||
        requerimiento.getServletPath().equals("/api/canciones") ){
            filtro.doFilter(requerimiento, respuesta);
            return;
        }

        try{

        String autentico = requerimiento.getHeader("Authorization");
        if(autentico!=null && autentico.startsWith("Bearer ")){
            String token = autentico.substring(7);
            String username=util.extractUsername(token);
            if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
                if (util.validateToken(token, username)) {
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
        }
        filtro.doFilter(requerimiento, respuesta);

        } catch (Exception e){
            respuesta.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            respuesta.getWriter().write("Token invalido o expirado");
        }

    }
}
