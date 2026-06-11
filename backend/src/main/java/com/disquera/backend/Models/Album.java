package com.disquera.backend.Models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
public class Album {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable=false)
    protected String nombre;

    @Min(1700)
    @Max(3000)
    protected int estreno;

    @Column(nullable = false)
    protected String descripcion;

    @Column(nullable = false)
    protected String urlPortada;

    public Album(){}

    public Long getId(){
        return id;
    }

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

    public void setId(Long id){
        this.id=id;
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

    public Artista getArtista(){
        return artista;
    }

    public void setArtista(Artista artista){
        this.artista=artista;
    }

    public Disquera getDisquera(){
        return disquera;
    }

    public void setDisquera(Disquera disquera){
        this.disquera=disquera;
    }

    public List getCanciones(){
        return canciones;
    }

    public void setCanciones(List canciones){
        this.canciones=canciones;
    }

    @ManyToOne (fetch=FetchType.LAZY)
    Artista artista;

    @ManyToOne
    Disquera disquera;

    @OneToMany (mappedBy="album")
    List<Cancion> canciones;

}
