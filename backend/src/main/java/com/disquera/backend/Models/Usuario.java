package com.disquera.backend.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    protected String username;

    @Column(nullable = false)
    protected String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    protected RolUsuario rol;

    public Usuario(){}

    public Long getId(){
        return id;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public RolUsuario getRol(){
        return rol;
    }

    public void setId(Long id){
        this.id=id;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public void setRol(RolUsuario rol){
        this.rol=rol;
    }

    public UsuarioComun getPerfil(){
        return perfil;
    }

    public void setPerfil(UsuarioComun perfil){
        this.perfil=perfil;
    }

    @OneToOne
    @JsonIgnore
    protected UsuarioComun perfil;
}
