package com.disquera.backend.Controllers;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.disquera.backend.Models.Autenticacion;
import com.disquera.backend.Security.JwtUtil;

@RestController
public class LoginController {
    private final JwtUtil util;
    private final AuthenticationManager manager;

    public LoginController(JwtUtil util, AuthenticationManager manager){
        this.util=util;
        this.manager=manager;
    }

    

    @PostMapping("/api/login")
    public String acceso(@RequestBody Autenticacion inicio ){
        manager.authenticate(new UsernamePasswordAuthenticationToken(inicio.getUsername(),inicio.getPassword()));
        String tokenr=util.generatedToken(inicio.getUsername());
        return tokenr;
    }
    
}
