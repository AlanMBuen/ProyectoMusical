import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { usuariocomun } from '../Models/usuariocomun.models';
import { PlanUsuario } from '../Models/planusuario.models';

@Injectable({
  providedIn: 'root',
})
export class Usuariocomun {

  private url = ('http://localhost:8080/api/usuarioscomunes');
  private http = inject(HttpClient);

  obtenertodos(){
    return this.http.get<usuariocomun[]>(`${this.url}`);
  }
  obtenerxid(id: number){
    return this.http.get<usuariocomun>(`${this.url}/id/${id}`)
  }

  obtenerxnombre(nombre: string){
    return this.http.get<usuariocomun[]>(`${this.url}/nombre/${nombre}`)
  }

  obtenerxplan(plan: PlanUsuario){
    return this.http.get<usuariocomun[]>(`${this.url}/plan/${plan}`)
  }

  crearusuariocomun(nusuariocomun: usuariocomun){
    return this.http.post<usuariocomun>(`${this.url}`, nusuariocomun);
  }

  editarusuariocomun(eusuariocomun: usuariocomun, id: number){
    return this.http.put<usuariocomun>(`${this.url}/editar/${id}`,eusuariocomun);
  }

  eliminarusuariocomun(id: number){
    return this.http.delete<void>(`${this.url}/eliminar/${id}`);
  }
}
