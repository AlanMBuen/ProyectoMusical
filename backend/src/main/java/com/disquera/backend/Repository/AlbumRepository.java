package com.disquera.backend.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disquera.backend.Models.Album;

@Repository
public interface AlbumRepository extends JpaRepository <Album, Long> {

    Optional<Album> findById(Long id);

    List<Album> findByNombre(String nombre);

    List<Album> findByEstreno(int estreno);

    List<Album> findByArtistaId(Long id);

    List<Album> findByCancionesId(Long id);

    List<Album> findByDisqueraId(Long id);
    
}
