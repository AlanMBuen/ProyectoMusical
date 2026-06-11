package com.disquera.backend.Dto;

import java.util.List;

public class ArtistaDTO {
    private String nombre;
    private String genero;
    private String descripcion;
    private String urlImagen;
    private Long disqueraId;
    private List<Long> artistasRelacionadosIds;

    public String getNombre(){
        return nombre;
    }

    public String getGenero(){
        return genero;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public String getUrlImagen(){
        return urlImagen;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setGenero(String genero){
        this.genero=genero;
    }

    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }

    public void setUrlImagen(String urlImagen){
        this.urlImagen=urlImagen;
    }

    public Long getDisqueraId(){
        return disqueraId;
    }

    public void setDisqueraId(Long disqueraId){
        this.disqueraId=disqueraId;
    }

    public List<Long> getArtistasRelacionadosIds(){
        return artistasRelacionadosIds;
    }

    public void setArtistasRelacionadosIds(List<Long> artistasRelacionadosIds){
        this.artistasRelacionadosIds=artistasRelacionadosIds;
    }
}
