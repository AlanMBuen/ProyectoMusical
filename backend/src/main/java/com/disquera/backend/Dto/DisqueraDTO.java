package com.disquera.backend.Dto;

public class DisqueraDTO {
    
    private String nombre;
    private String descripcion;
    private int creacion;
    

    public String getNombre(){
        return nombre;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public int getCreacion(){
        return creacion;
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
}
