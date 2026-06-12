import { HttpClient } from '@angular/common/http';
import {  inject, Injectable } from '@angular/core';
import { usuario } from '../Models/usuario.models';
import { RolUsuario } from '../Models/rolusuario.models';

@Injectable({
  providedIn: 'root',
})
export class Usuario {

  private url = ('http://localhost:8080/api/usuarios');
  private http= inject(HttpClient);

  obtenertodos(){
    return this.http.get<usuario[]>(`${this.url}`);
  }

  obtenerxid(id: number){
    return this.http.get<usuario>(`${this.url}/id/${id}`)
  }

  obtenerxnombre(nombre: string){
    return this.http.get<usuario[]>(`${this.url}/nombre/${nombre}`)
  }

  obtenerxrol(rol: RolUsuario){
    return this.http.get<usuario[]>(`${this.url}/rol/${rol}`)
  }

  obtenerxperfil(id: number){
    return this.http.get<usuario[]>(`${this.url}/perfil/${id}`)
  }

  crearusuario(nusuario: usuario){
    return this.http.post<usuario>(`${this.url}`, nusuario);
  }

  editarusuario(eusuario: usuario, id: number){
    return this.http.put<usuario>(`${this.url}/editar/${id}`,eusuario);
  }

  eliminarusuario(id: number){
    return this.http.delete<void>(`${this.url}/eliminar/${id}`);
  }
}
