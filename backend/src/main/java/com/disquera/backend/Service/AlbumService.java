package com.disquera.backend.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.disquera.backend.Dto.AlbumDTO;
import com.disquera.backend.Exception.ResourceNotFoundException;
import com.disquera.backend.Models.Album;
import com.disquera.backend.Models.Artista;
import com.disquera.backend.Models.Disquera;
import com.disquera.backend.Repository.AlbumRepository;
import com.disquera.backend.Repository.ArtistaRepository;
import com.disquera.backend.Repository.DisqueraRepository;

@Service
public class AlbumService {
    private final AlbumRepository albumRepository;
    private final DisqueraRepository disqueraRepository;
    private final ArtistaRepository artistaRepository;

    public AlbumService(AlbumRepository albumRepository, DisqueraRepository disqueraRepository, ArtistaRepository artistaRepository){
        this.albumRepository=albumRepository;
        this.disqueraRepository=disqueraRepository;
        this.artistaRepository=artistaRepository;
    }

    public List<Album> buscartodos(){
        return albumRepository.findAll();
    }

    public Album buscarxid(Long id){
        return albumRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Album no encontrado"));
    }

    public List<Album> buscarxnombre (String nombre){
        return albumRepository.findByNombre(nombre);
    }

    public List<Album> buscarxestreno (int estreno){
        return albumRepository.findByEstreno(estreno);
    }

    public List<Album> buscarxartista (Long id){
        return albumRepository.findByArtistaId(id);
    }

    public List<Album> buscarxcancion (Long id){
        return albumRepository.findByCancionesId(id);
    }

    public List<Album> buscarxdisquera (Long id){
        return albumRepository.findByDisqueraId(id);
    }

    public Album crearalbum (AlbumDTO dtoalbum){
        Album nalbum=new Album();
        nalbum.setNombre(dtoalbum.getNombre());
        nalbum.setDescripcion(dtoalbum.getDescripcion());
        nalbum.setUrlPortada(dtoalbum.getUrlPortada());
        nalbum.setEstreno(dtoalbum.getEstreno());
        Artista artista =artistaRepository.findById(dtoalbum.getArtistaId())
            .orElseThrow(()->new ResourceNotFoundException("Artista no encontrado"));
        nalbum.setArtista(artista);

        if (dtoalbum.getDisqueraId() != null) {
            Disquera disquera = disqueraRepository.findById(dtoalbum.getDisqueraId())
                .orElseThrow(()-> new ResourceNotFoundException("Disquera no encontrado"));
            nalbum.setDisquera(disquera);
        }

        return albumRepository.save(nalbum);

    }

    public Album editaralbum (AlbumDTO dtoalbum, Long id){
        Album ealbum=albumRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Album no encontrado"));
        
        ealbum.setNombre(dtoalbum.getNombre());
        ealbum.setDescripcion(dtoalbum.getDescripcion());
        ealbum.setUrlPortada(dtoalbum.getUrlPortada());
        ealbum.setEstreno(dtoalbum.getEstreno());

        if (dtoalbum.getArtistaId() != null) {
            Artista artista =artistaRepository.findById(dtoalbum.getArtistaId())
                .orElseThrow(()->new ResourceNotFoundException("Artista no encontrado"));
            ealbum.setArtista(artista);
        }

        if (dtoalbum.getDisqueraId() != null) {
            Disquera disquera = disqueraRepository.findById(dtoalbum.getDisqueraId())
                .orElseThrow(()-> new ResourceNotFoundException("Disquera no encontrado"));
            ealbum.setDisquera(disquera);
        }

        return albumRepository.save(ealbum);
    }

    public void eliminarartista (Long id){
        albumRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Album no encontrado"));
        albumRepository.deleteById(id);
    }

    
}
