package com.disquera.backend.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disquera.backend.Models.Disquera;

@Repository
public interface  DisqueraRepository extends JpaRepository <Disquera,Long>{

    Optional<Disquera> findById(Long id);
    
    List<Disquera> findByNombre(String nombre);
    
    List<Disquera> findByAlbumesId(Long id);

    List<Disquera> findByCreacion(int creacion);

    List<Disquera> findByArtistasId(Long id);
}
