package com.disquera.backend.Dto;

public class AlbumDTO {

    private String nombre;
    private String descripcion;
    private String urlPortada;
    private int estreno;
    private Long artistaId;
    private Long disqueraId;

    public String getNombre(){
        return nombre;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public String getUrlPortada(){
        return urlPortada;
    }

    public int getEstreno(){
        return estreno;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }

    public void setUrlPortada(String urlPortada){
        this.urlPortada=urlPortada;
    }

    public void setEstreno(int estreno){
        this.estreno=estreno;
    }

    public Long getArtistaId(){
        return artistaId;
    }

    public void setArtistaId(Long artistaId){
        this.artistaId=artistaId;
    }

    public Long getDisqueraId(){
        return disqueraId;
    }

    public void setDisqueraId(Long disqueraId){
        this.disqueraId=disqueraId;
    }
}
