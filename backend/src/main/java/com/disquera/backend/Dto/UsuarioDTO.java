package com.disquera.backend.Dto;

import com.disquera.backend.Models.RolUsuario;

public class UsuarioDTO {
    private String username;
    private String password;
    private RolUsuario rol;
    

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public RolUsuario getRol(){
        return rol;
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
}
