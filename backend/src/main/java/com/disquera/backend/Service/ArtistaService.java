package com.disquera.backend.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.disquera.backend.Dto.ArtistaDTO;
import com.disquera.backend.Exception.ResourceNotFoundException;
import com.disquera.backend.Models.Artista;
import com.disquera.backend.Models.Disquera;
import com.disquera.backend.Repository.ArtistaRepository;
import com.disquera.backend.Repository.DisqueraRepository;

@Service
public class ArtistaService {
    private final ArtistaRepository artistaRepository;
    private final DisqueraRepository disqueraRepository;

    public ArtistaService(ArtistaRepository artistaRepository, DisqueraRepository disqueraRepository){
        this.artistaRepository=artistaRepository;
        this.disqueraRepository=disqueraRepository;
    }

    public List<Artista> obtenertodos(){
        return artistaRepository.findAll();
    }

    public Artista obtenerxid (Long id){
        return artistaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Artista no encontrado"));
    }

    public List<Artista> obtenerxnombre(String nombre){
        return artistaRepository.findByNombre(nombre);
    }

    public List<Artista> obtenerxgenero(String genero){
        return artistaRepository.findByGenero(genero);
    }

    public Artista crearArtista (ArtistaDTO dtoartista){
        Artista nartista = new Artista();
        nartista.setNombre(dtoartista.getNombre());
        nartista.setGenero(dtoartista.getGenero());
        nartista.setDescripcion(dtoartista.getDescripcion());
        nartista.setUrlImagen(dtoartista.getUrlImagen());

        if (dtoartista.getDisqueraId() != null) {
            Disquera disquera = disqueraRepository.findById(dtoartista.getDisqueraId())
                .orElseThrow(()-> new ResourceNotFoundException("Disquera no encontrado"));
            nartista.setDisquera(disquera);
        }

        if(dtoartista.getArtistasRelacionadosIds() != null){
            List<Artista> relacionados = artistaRepository.findAllById(dtoartista.getArtistasRelacionadosIds());
            nartista.setArtistasRelacionados(relacionados);
        }

        return artistaRepository.save(nartista);
    }

    public Artista editarArtista (ArtistaDTO dtoartista, Long id){
        Artista eartista = artistaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Artista no encontrado"));
        eartista.setNombre(dtoartista.getNombre());
        eartista.setGenero(dtoartista.getGenero());
        eartista.setDescripcion(dtoartista.getDescripcion());
        eartista.setUrlImagen(dtoartista.getUrlImagen());

        if (dtoartista.getDisqueraId() != null) {
            Disquera disquera = disqueraRepository.findById(dtoartista.getDisqueraId())
                .orElseThrow(()-> new ResourceNotFoundException("Disquera no encontrado"));
            eartista.setDisquera(disquera);
        }

        if(dtoartista.getArtistasRelacionadosIds() != null){
            List<Artista> relacionados = artistaRepository.findAllById(dtoartista.getArtistasRelacionadosIds());
            eartista.setArtistasRelacionados(relacionados);
        }
        return artistaRepository.save(eartista);
    }

    public void eliminarArtista (Long id){
        artistaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Artista no encontrado"));
        artistaRepository.deleteById(id);
    }
    
}
