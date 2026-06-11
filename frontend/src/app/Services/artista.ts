import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { artista } from '../Models/artista.models';

@Injectable({
  providedIn: 'root',
})
export class Artista {

  private url = ('http://localhost:8080/api/artistas');
  private http = inject(HttpClient);

  obtenertodos(){
    return this.http.get<artista[]>(`${this.url}`);
  }

  obtenerxid(id: number){
    return this.http.get<artista>(`${this.url}/id/${id}`)
  }

  obtenerxnombre(nombre: string){
    return this.http.get<artista[]>(`${this.url}/nombre/${nombre}`)
  }

  obtenerxgenero(genero: string){
    return this.http.get<artista[]>(`${this.url}/genero/${genero}`)
  }

  crearartista(nartista: artista){
    return this.http.post<artista>(`${this.url}`, nartista);
  }

  editarartista(eartista: artista, id: number){
    return this.http.put<artista>(`${this.url}/editar/${id}`,eartista);
  }

  eliminarartista(id: number){
    return this.http.delete<void>(`${this.url}/eliminar/${id}`);
  }
}