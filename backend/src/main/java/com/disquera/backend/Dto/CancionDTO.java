package com.disquera.backend.Dto;

import java.util.List;

public class CancionDTO {

    private String nombre;
    private String genero;
    private String descripcion;
    private String urlAudio;
    private int duracion;
    private List<Long> artistasId;
    private Long albumId;

    public String getNombre(){
        return nombre;
    }

    public String getGenero(){
        return genero;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public String getUrlAudio(){
        return urlAudio;
    }

    public int getDuracion(){
        return duracion;
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

    public void setUrlAudio(String urlAudio){
        this.urlAudio=urlAudio;
    }

    public void setDuracion(int duracion){
        this.duracion=duracion;
    }

    public List<Long> getArtistasId(){
        return artistasId;
    }

    public void setArtistasId(List<Long> artistasId){
        this.artistasId=artistasId;
    }

    public Long getAlbumId(){
        return albumId;
    }

    public void setAlbumId(Long albumId){
        this.albumId=albumId;
    }
    
}
