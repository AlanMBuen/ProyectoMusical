package com.disquera.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disquera.backend.Models.Artista;
import java.util.List;
import java.util.Optional;


@Repository
public interface ArtistaRepository extends JpaRepository <Artista, Long> {

    Optional<Artista> findById(Long id);

    List<Artista> findByNombre(String nombre);

    List<Artista> findByGenero(String genero);
    
}
