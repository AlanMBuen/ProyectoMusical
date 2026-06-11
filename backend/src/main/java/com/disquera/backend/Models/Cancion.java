package com.disquera.backend.Models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;

@Entity
public class Cancion {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    protected String nombre;

    @Column(nullable = false)
    protected String genero;

    @Column(nullable = false)
    protected String descripcion;

    @Column(nullable = false)
    protected String urlAudio;

    @Min(0)
    protected int duracion;

    @Min(0)
    protected int reproducciones;

    public Cancion(){}

    public Long getId(){
        return id;
    }

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

    public int getReproducciones(){
        return reproducciones;
    }

    public void setId(Long id){
        this.id=id;
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

    public void setReproducciones(int reproducciones){
        this.reproducciones=reproducciones;
    }

    public List getArtistas(){
        return artistas;
    }

    public void setArtistas(List artistas){
        this.artistas=artistas;
    }

    public Album getAlbum(){
        return album;
    }

    public void setAlbum(Album album){
        this.album=album;
    }

    public List getPlayList(){
        return playlists;
    }

    public void setPlayList(List playlists){
        this.playlists=playlists;
    }

    @ManyToMany
    List<Artista> artistas;

    @ManyToOne
    Album album;

    @ManyToMany
    List<PlayList> playlists;

    
}
