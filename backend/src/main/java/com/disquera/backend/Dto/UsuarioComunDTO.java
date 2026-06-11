package com.disquera.backend.Dto;

import com.disquera.backend.Models.PlanUsuario;

public class UsuarioComunDTO {
    private String nombre;
    private PlanUsuario plan;
    private Long usuarioId;
    

    public String getNombre(){
        return nombre;
    }

    public PlanUsuario getPlan(){
        return plan;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setPlan(PlanUsuario plan){
        this.plan=plan;
    }

    public Long getUsuarioId(){
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId){
        this.usuarioId=usuarioId;
    }

}
