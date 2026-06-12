import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { cancion } from '../Models/cancion.models';

@Injectable({
  providedIn: 'root',
})
export class Cancion {

  private url = ('http://localhost:8080/api/canciones');
  private http = inject(HttpClient);

  obtenertodos(){
    return this.http.get<cancion[]>(`${this.url}`);
  }

  obtenerxid(id: number){
    return this.http.get<cancion>(`${this.url}/id/${id}`)
  }

  obtenerxnombre(nombre: string){
    return this.http.get<cancion[]>(`${this.url}/nombre/${nombre}`)
  }

  obtenerxgenero(genero: string){
    return this.http.get<cancion[]>(`${this.url}/genero/${genero}`)
  }

  obtenerxduracion(duracion: number){
    return this.http.get<cancion[]>(`${this.url}/duracion/${duracion}`)
  }

  obtenerxartista(id: number){
    return this.http.get<cancion[]>(`${this.url}/artista/${id}`)
  }

  obtenerxalbum(id: number){
    return this.http.get<cancion[]>(`${this.url}/album/${id}`)
  }

  crearcancion(ncancion: cancion){
    return this.http.post<cancion>(`${this.url}`, ncancion);
  }

  editarcancion(ecancion: cancion, id: number){
    return this.http.put<cancion>(`${this.url}/editar/${id}`,ecancion);
  }

  eliminarcancion(id: number){
    return this.http.delete<void>(`${this.url}/eliminar/${id}`);
  }
}
