package com.disquera.backend.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class UsuarioComun {
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    protected String nombre;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    protected PlanUsuario plan;

    public UsuarioComun(){}

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

    public List<Artista> getSeguidos(){
        return seguidos;
    }

    public void setSeguidos(List<Artista> seguidos){
        this.seguidos=seguidos;
    }

    public List<PlayList> getPlayList(){
        return playlists;
    }

    public void setPlayList(List<PlayList> playlists){
        this.playlists=playlists;
    }

    public Usuario getUsername(){
        return username;
    }

    public void setUsername (Usuario username){
        this.username=username;
    }

    @ManyToMany
    @JsonIgnore
    List<Artista> seguidos;

    @OneToMany (mappedBy="creador")
    List<PlayList> playlists;

    @OneToOne(mappedBy = "perfil")
    @JsonIgnore
    protected Usuario username;
    
}
