package com.disquera.backend.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disquera.backend.Models.PlayList;

@Repository
public interface PlayListRepository extends JpaRepository <PlayList, Long>{

    Optional<PlayList> findById(Long id);

    List<PlayList> findByNombre(String nombre);
    
}
