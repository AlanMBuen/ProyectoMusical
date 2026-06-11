package com.disquera.backend.Security;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.disquera.backend.Models.Usuario;
import com.disquera.backend.Repository.UsuarioRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    public final UsuarioRepository repository;
    public UserDetailsServiceImpl(UsuarioRepository repository){
        this.repository=repository;
    }


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Usuario usuario = repository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("Usuario no encontrado"));

        return new User(usuario.getUsername(), usuario.getPassword(), new ArrayList<>());
    }
    
}
