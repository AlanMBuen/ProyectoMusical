package com.disquera.backend.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disquera.backend.Models.RolUsuario;
import com.disquera.backend.Models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Long>{

    Optional<Usuario> findById(Long id);

    Optional<Usuario> findByUsername(String username);

    List<Usuario> findByPerfilId(Long id);

    List<Usuario> findByRol(RolUsuario rol);

    
}
