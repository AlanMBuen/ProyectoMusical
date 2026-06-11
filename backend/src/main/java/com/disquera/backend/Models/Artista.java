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
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;

@Entity
public class Artista {
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    protected String nombre;

    @Column(nullable = false)
    protected String genero;

    @Column(nullable = false)
    protected String descripcion;

    @Column(nullable = false)
    protected String urlImagen;

    @Min(0)
    protected int numseguidores;

    public Artista(){}

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

    public String getUrlImagen(){
        return urlImagen;
    }

    public int getNumSeguidores(){
        return numseguidores;
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

    public void setUrlImagen(String urlImagen){
        this.urlImagen=urlImagen;
    }

    public void setNumSeguidores(int numseguidores){
        this.numseguidores=numseguidores;
    }

    public List getAlbumes(){
        return albumes;
    }

    public void setAlbumes(List albumes){
        this.albumes=albumes;
    }

    public List getCanciones(){
        return canciones;
    }

    public void setCanciones(List canciones){
        this.canciones=canciones;
    }

    public Disquera getDisquera(){
        return disquera;
    }

    public void setDisquera(Disquera disquera){
        this.disquera=disquera;
    }

    public List getSeguidores(){
        return seguidores;
    }

    public void setSeguidores(List seguidores){
        this.seguidores=seguidores;
    }

    public List getArtistasRelacionados(){
        return artistasRelacionados;
    }

    public void setArtistasRelacionados(List artistasRelacionados){
        this.artistasRelacionados=artistasRelacionados;
    }


    @OneToMany (mappedBy="artista")
    List<Album> albumes;

    @ManyToMany
    @JsonIgnore
    List<Cancion> canciones;

    @ManyToOne
    Disquera disquera;

    @ManyToMany
    @JsonIgnore
    List<UsuarioComun> seguidores;


    @ManyToMany
    @JsonIgnore
    List<Artista> artistasRelacionados;

}

/*Espero se entienda la idea de las relaciones,
    quiero poder subir musica al sistema, obvio sera casi nada ahora por proyecto simple
    quiero relacionar las tablas como lo intente describir
    quiero que el usuario suba musica, elimine solo su musica y editar sus etiquetas de la musica o album, ademas de tener el perfil plus de los usuarios
    quiero que el usuario comun tenga su perfil basico donde solo pueda seguir artistas y un plus donde siga artistas y pueda crear, editar y eliminar sus propias playlist de las canciones que quieran
    quiero que un perfil admin pueda hacer todo lo anterior mas eliminar, crear y editar artistas, albums, canciones y disqueras

    veme diciendo lo que me va faltando hasta ahora, nombres en relaciones o caracteristicas que omiti
    */
