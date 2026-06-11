package com.disquera.backend.Service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.disquera.backend.Dto.UsuarioDTO;
import com.disquera.backend.Exception.ResourceNotFoundException;
import com.disquera.backend.Models.RolUsuario;
import com.disquera.backend.Models.Usuario;
import com.disquera.backend.Repository.UsuarioRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder codificado;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder codificado){
        this.usuarioRepository=usuarioRepository;
        this.codificado=codificado;
    }

    public List<Usuario> obtenertodos(){
        return usuarioRepository.findAll();
    }

    public Usuario obtenerxid(Long id){
        return usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
    }

    public Usuario obtenerxnombre(String username){
        return usuarioRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
    }

    public List<Usuario> obtenerxperfil(Long id){
        return usuarioRepository.findByPerfilId(id);
    }

    public List<Usuario> obtenerxrol (RolUsuario rol){
        return usuarioRepository.findByRol(rol);
    }

    public Usuario crearusuario(UsuarioDTO dtousuario){
        Usuario nusuario = new Usuario();
        nusuario.setUsername(dtousuario.getUsername());
        nusuario.setPassword(codificado.encode(dtousuario.getPassword()));
        nusuario.setRol(dtousuario.getRol());
        return usuarioRepository.save(nusuario);
    }

    public Usuario editarusuario(UsuarioDTO dtousuario, Long id){
        Usuario eusuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        eusuario.setUsername(dtousuario.getUsername());
        eusuario.setPassword(codificado.encode(dtousuario.getPassword()));
        eusuario.setRol(dtousuario.getRol());
        return usuarioRepository.save(eusuario);
    }

    public void eliminarusuario(Long id){
        usuarioRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Usuario no encontrado"));
        usuarioRepository.deleteById(id);
    }


    
}
