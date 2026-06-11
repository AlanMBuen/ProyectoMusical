package com.disquera.backend.Models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
public class Disquera {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable=false)
    protected String nombre;

    @Min(1700)
    @Max(3000)
    protected int creacion;

    @Column(nullable = false)
    protected String descripcion;

    public Disquera(){}

    public Long getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public int getCreacion(){
        return creacion;
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

    public void setCreacion(int creacion){
        this.creacion=creacion;
    }

    public List getArtistas(){
        return artistas;
    }

    public void setArtistas(List artistas){
        this.artistas=artistas;
    }

    public List getAlbumes(){
        return albumes;
    }

    public void setAlbumes(List albumes){
        this.albumes=albumes;
    }



    @OneToMany (mappedBy="disquera")
    List<Artista> artistas;

    @OneToMany (mappedBy="disquera")
    List<Album> albumes;
    
}
