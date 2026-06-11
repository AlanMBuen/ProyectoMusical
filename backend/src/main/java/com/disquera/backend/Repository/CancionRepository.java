package com.disquera.backend.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disquera.backend.Models.Cancion;

@Repository
public interface CancionRepository extends JpaRepository <Cancion, Long> {

    Optional<Cancion> findById(Long id);

    List<Cancion> findByNombre(String nombre);

    List<Cancion> findByGenero(String genero);

    List<Cancion> findByDuracion(int duracion);

    List<Cancion> findByArtistasId(Long id);

    List<Cancion> findByAlbumId(Long id);
    
}
