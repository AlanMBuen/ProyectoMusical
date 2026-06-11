package com.disquera.backend.Dto;

import java.util.List;

public class PlayListDTO {
    private String nombre;
    private Long creadorId;
    private List<Long> cancionesId;

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public Long getCreadorId(){
        return creadorId;
    }

    public void setCreadorId(Long creadorId){
        this.creadorId=creadorId;
    }

    public List<Long> getCancionesId(){
        return cancionesId;
    }

    public void setCancionesId(List<Long> cancionesId){
        this.cancionesId=cancionesId;
    }
}
