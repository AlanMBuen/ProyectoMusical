package com.disquera.backend.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.disquera.backend.Dto.DisqueraDTO;
import com.disquera.backend.Exception.ResourceNotFoundException;
import com.disquera.backend.Models.Disquera;
import com.disquera.backend.Repository.DisqueraRepository;

@Service
public class DisqueraService {
    private final DisqueraRepository disqueraRepository;

    public DisqueraService(DisqueraRepository disqueraRepository){
        this.disqueraRepository=disqueraRepository;
    }

    public List<Disquera> obtenertodos(){
        return disqueraRepository.findAll();
    }

    public Disquera obtenerxid(Long id){
        return disqueraRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Disquera no encontrado"));
    }

    public List<Disquera> obtenerxnombre(String nombre){
        return disqueraRepository.findByNombre(nombre);
    }

    public List<Disquera> obtenerxalbumes(Long id){
        return disqueraRepository.findByAlbumesId(id);
    }

    public List<Disquera> obtenerxcreacion(int creacion){
        return disqueraRepository.findByCreacion(creacion);
    }

    public List<Disquera> obtenerxartistas(Long id){
        return disqueraRepository.findByArtistasId(id);
    }

    public Disquera creardisquera(DisqueraDTO dtodisquera){
        Disquera ndisquera= new Disquera();
        ndisquera.setNombre(dtodisquera.getNombre());
        ndisquera.setDescripcion(dtodisquera.getDescripcion());
        ndisquera.setCreacion(dtodisquera.getCreacion());
        return disqueraRepository.save(ndisquera);
    }

    public Disquera editardisquera(DisqueraDTO disqueraDTO, Long id){
        Disquera edisquera = disqueraRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Disquera no encontrado"));
        edisquera.setNombre(disqueraDTO.getNombre());
        edisquera.setDescripcion(disqueraDTO.getDescripcion());
        edisquera.setCreacion(disqueraDTO.getCreacion());
        return disqueraRepository.save(edisquera);
    }

    public void eliminardisquera(Long id){
        disqueraRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Disquera no encontrado"));
        disqueraRepository.deleteById(id);
    }
}
