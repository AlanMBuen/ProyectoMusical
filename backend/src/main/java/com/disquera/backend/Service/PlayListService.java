package com.disquera.backend.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.disquera.backend.Dto.PlayListDTO;
import com.disquera.backend.Exception.ResourceNotFoundException;
import com.disquera.backend.Models.Cancion;
import com.disquera.backend.Models.PlayList;
import com.disquera.backend.Models.UsuarioComun;
import com.disquera.backend.Repository.CancionRepository;
import com.disquera.backend.Repository.PlayListRepository;
import com.disquera.backend.Repository.UsuarioComunRepository;

@Service
public class PlayListService {
    private final PlayListRepository playListRepository;
    private final UsuarioComunRepository usuarioComunRepository;
    private final CancionRepository cancionRepository;

    public PlayListService(PlayListRepository playListRepository,UsuarioComunRepository usuarioComunRepository, CancionRepository cancionRepository){
        this.playListRepository=playListRepository;
        this.usuarioComunRepository=usuarioComunRepository;
        this.cancionRepository=cancionRepository;
    }

    public List<PlayList> obtenertodos (){
        return playListRepository.findAll();
    }

    public PlayList obtenerxid(Long id){
        return playListRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PlayList no encontrado"));
    }

    public List<PlayList> obtenerxnombre(String nombre){
        return playListRepository.findByNombre(nombre);
    }

    public PlayList crearplaylist(PlayListDTO dtoplaylist){
        PlayList nplaylist = new PlayList();
        nplaylist.setNombre(dtoplaylist.getNombre());

        UsuarioComun creador = usuarioComunRepository.findById(dtoplaylist.getCreadorId())
            .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        nplaylist.setCreador(creador);

        if(dtoplaylist.getCancionesId() != null){
        List<Cancion> cancion = cancionRepository.findAllById(dtoplaylist.getCancionesId());
        nplaylist.setCanciones(cancion);
        }

        return playListRepository.save(nplaylist);
    }

    public PlayList editarplaylist(PlayListDTO dtoplaylist, Long id){
        PlayList eplaylist = playListRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PlayList no encontrado"));
        eplaylist.setNombre(dtoplaylist.getNombre());

        if(dtoplaylist.getCreadorId() != null){
        UsuarioComun creador = usuarioComunRepository.findById(dtoplaylist.getCreadorId())
            .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        eplaylist.setCreador(creador);
        }

        if(dtoplaylist.getCancionesId() != null){
        List<Cancion> cancion = cancionRepository.findAllById(dtoplaylist.getCancionesId());
        eplaylist.setCanciones(cancion);
        }

        return playListRepository.save(eplaylist);
    }

    public void eliminarplaylist(Long id){
        playListRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PlayList no encontrado"));
        playListRepository.deleteById(id);
    }
    
}
