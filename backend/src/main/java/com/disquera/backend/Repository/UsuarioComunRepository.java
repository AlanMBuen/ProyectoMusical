package com.disquera.backend.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disquera.backend.Models.PlanUsuario;
import com.disquera.backend.Models.UsuarioComun;

@Repository
public interface UsuarioComunRepository extends JpaRepository <UsuarioComun, Long> {

    Optional<UsuarioComun> findById(Long id);

    List<UsuarioComun> findByNombre(String nombre);

    List<UsuarioComun> findByPlan(PlanUsuario plan);
    
}
