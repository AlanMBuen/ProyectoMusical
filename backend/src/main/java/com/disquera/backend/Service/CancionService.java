package com.disquera.backend.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.disquera.backend.Dto.CancionDTO;
import com.disquera.backend.Exception.ResourceNotFoundException;
import com.disquera.backend.Models.Album;
import com.disquera.backend.Models.Artista;
import com.disquera.backend.Models.Cancion;
import com.disquera.backend.Repository.AlbumRepository;
import com.disquera.backend.Repository.ArtistaRepository;
import com.disquera.backend.Repository.CancionRepository;

@Service
public class CancionService {
    private final CancionRepository cancionRepository;
    private final ArtistaRepository artistaRepository;
    private final AlbumRepository albumRepository;

    public CancionService(CancionRepository cancionRepository, ArtistaRepository artistaRepository, AlbumRepository albumRepository){
        this.cancionRepository=cancionRepository;
        this.artistaRepository=artistaRepository;
        this.albumRepository=albumRepository;
    }

    public List<Cancion> obtenertodos(){
        return cancionRepository.findAll();
    }

    public Cancion obtenerxid(Long id){
        return cancionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cancion no encontrado"));
    }

    public List<Cancion> obtenerxnombre(String nombre){
        return cancionRepository.findByNombre(nombre);
    }

    public List<Cancion> obtenerxgenero(String genero){
        return cancionRepository.findByGenero(genero);
    }

    public List<Cancion> obtenerxduracion(int duracion){
        return cancionRepository.findByDuracion(duracion);
    }

    public List<Cancion> obtenerxartista(Long id){
        return cancionRepository.findByArtistasId(id);
    }

    public List<Cancion> obtenerxalbum(Long id){
        return cancionRepository.findByAlbumId(id);
    }

    public Cancion crearcancion(CancionDTO dtocancion){
        Cancion ncancion = new Cancion();
        ncancion.setNombre(dtocancion.getNombre());
        ncancion.setGenero(dtocancion.getGenero());
        ncancion.setDescripcion(dtocancion.getDescripcion());
        ncancion.setUrlAudio(dtocancion.getUrlAudio());
        ncancion.setDuracion(dtocancion.getDuracion());

        List<Artista> artistas =artistaRepository.findAllById(dtocancion.getArtistasId());
        ncancion.setArtistas(artistas);

        Album album = albumRepository.findById(dtocancion.getAlbumId())
            .orElseThrow(() -> new ResourceNotFoundException("Album no encontrado"));
        ncancion.setAlbum(album);

        return cancionRepository.save(ncancion);
    }

    public Cancion editarcancion(CancionDTO dtocancion, Long id){
        Cancion ecancion = cancionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cancion no encontrado"));
        ecancion.setNombre(dtocancion.getNombre());
        ecancion.setGenero(dtocancion.getGenero());
        ecancion.setDescripcion(dtocancion.getDescripcion());
        ecancion.setUrlAudio(dtocancion.getUrlAudio());
        ecancion.setDuracion(dtocancion.getDuracion());

        if(dtocancion.getArtistasId() != null){
            List<Artista> artistas =artistaRepository.findAllById(dtocancion.getArtistasId());
            ecancion.setArtistas(artistas);
        }

        if(dtocancion.getAlbumId() != null){
            Album album = albumRepository.findById(dtocancion.getAlbumId())
                .orElseThrow(() -> new ResourceNotFoundException("Album no encontrado"));
            ecancion.setAlbum(album);
        }

        return cancionRepository.save(ecancion);

    }

    public void eliminarcancion(Long id){
        cancionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cancion no encontrado"));
        cancionRepository.deleteById(id);
    }

}
