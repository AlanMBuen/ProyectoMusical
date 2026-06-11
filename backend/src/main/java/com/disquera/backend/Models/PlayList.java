package com.disquera.backend.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class PlayList {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    protected String nombre;

    public PlayList(){}

    public Long getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setId(Long id){
        this.id=id;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public UsuarioComun getCreador(){
        return creador;
    }

    public void setCreador(UsuarioComun creador){
        this.creador=creador;
    }

    public List getCanciones(){
        return canciones;
    }

    public void setCanciones(List canciones){
        this.canciones=canciones;
    }

    @ManyToOne
    UsuarioComun creador;

    @ManyToMany
    @JsonIgnore
    List<Cancion> canciones;
    
}
