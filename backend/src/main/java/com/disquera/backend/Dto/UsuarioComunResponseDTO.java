package com.disquera.backend.Dto;

import java.util.List;

import com.disquera.backend.Models.PlanUsuario;

public class UsuarioComunResponseDTO {
    private Long id;
    private String nombre;
    private PlanUsuario plan;
    private List<Long> seguidosId;
    private List<Long> playlistId;
    private Long usuarioId;
    

    public Long getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public PlanUsuario getPlan(){
        return plan;
    }

    public void setId(Long id){
        this.id=id;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setPlan(PlanUsuario plan){
        this.plan=plan;
    }

    public List<Long> getSeguidosId(){
        return seguidosId;
    }

    public void setSeguidosId(List<Long> seguidosId){
        this.seguidosId=seguidosId;
    }

    public List<Long> getPlaylistId(){
        return playlistId;
    }

    public void setPlaylistId(List<Long> playlistId){
        this.playlistId=playlistId;
    }

    public Long getUsuarioId(){
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId){
        this.usuarioId=usuarioId;
    }

}
