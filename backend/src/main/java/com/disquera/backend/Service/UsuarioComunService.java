package com.disquera.backend.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.disquera.backend.Dto.UsuarioComunDTO;
import com.disquera.backend.Dto.UsuarioComunResponseDTO;
import com.disquera.backend.Exception.ResourceNotFoundException;
import com.disquera.backend.Models.PlanUsuario;
import com.disquera.backend.Models.Usuario;
import com.disquera.backend.Models.UsuarioComun;
import com.disquera.backend.Repository.UsuarioComunRepository;
import com.disquera.backend.Repository.UsuarioRepository;

@Service
public class UsuarioComunService {
    private final UsuarioComunRepository usuarioComunRepository;
    private final UsuarioRepository usuarioRepository;

    public UsuarioComunService(UsuarioComunRepository usuarioComunRepository,UsuarioRepository usuarioRepository){
        this.usuarioComunRepository=usuarioComunRepository;
        this.usuarioRepository=usuarioRepository;
    }

    private UsuarioComunResponseDTO cambiarentidad(UsuarioComun uc){
        UsuarioComunResponseDTO dto = new UsuarioComunResponseDTO();
        dto.setId(uc.getId());
        dto.setNombre(uc.getNombre());
        dto.setPlan(uc.getPlan());
        dto.setPlaylistId(uc.getPlayList().stream().map(p -> p.getId()).collect(Collectors.<Long>toList()));
        dto.setSeguidosId(uc.getSeguidos().stream().map(a -> a.getId()).collect(Collectors.<Long>toList()));
        dto.setUsuarioId(uc.getUsername() !=null ? uc.getUsername().getId():null);
        return dto;
    }

    public List<UsuarioComunResponseDTO> obtenertodos (){
        return usuarioComunRepository.findAll()
            .stream().map(uc -> cambiarentidad(uc))
            .collect(Collectors.toList());
    }

    public UsuarioComunResponseDTO obtenerxid (Long id){
        UsuarioComun uc = usuarioComunRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario Comun no encontrado"));
            return cambiarentidad(uc);
    }

    public List<UsuarioComunResponseDTO> obtenerxnombre(String nombre){
        return usuarioComunRepository.findByNombre(nombre)
            .stream().map(uc -> cambiarentidad(uc))
            .collect(Collectors.toList());
    }

    public List<UsuarioComunResponseDTO> obtenerxplan(PlanUsuario plan){
        return usuarioComunRepository.findByPlan(plan)
            .stream().map(uc -> cambiarentidad(uc))
            .collect(Collectors.toList());
    }

    public UsuarioComun crearusuariocomun(UsuarioComunDTO dtousuariocomun){
        UsuarioComun nusuariocomun = new UsuarioComun();
        nusuariocomun.setNombre(dtousuariocomun.getNombre());
        nusuariocomun.setPlan(dtousuariocomun.getPlan());

        Usuario usuario = usuarioRepository.findById(dtousuariocomun.getUsuarioId())
            .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        UsuarioComun guardado=usuarioComunRepository.save(nusuariocomun);
        usuario.setPerfil(guardado);
        usuarioRepository.save(usuario);

        return guardado;
    }

    public UsuarioComun editarusuariocomun(UsuarioComunDTO dtousuariocomun, Long id){
        UsuarioComun eusuariocomun = usuarioComunRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Usuario Comun no encontrado"));
        eusuariocomun.setNombre(dtousuariocomun.getNombre());
        eusuariocomun.setPlan(dtousuariocomun.getPlan());

        return usuarioComunRepository.save(eusuariocomun);
    }

    public void eliminarusuariocomun(Long id){
        usuarioComunRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario Comun no encontrado"));
        usuarioComunRepository.deleteById(id);
    }
    
}
