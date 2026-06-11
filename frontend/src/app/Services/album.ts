import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { album } from '../Models/album.models';

@Injectable({
  providedIn: 'root',
})
export class Album {
  
  private url= ('http://localhost:8080/api/albumes');
  private http=inject(HttpClient);

  obtenertodos(){
    return this.http.get<album[]>(`${this.url}`)
  }

  obtenerxid(id: number){
      return this.http.get<album>(`${this.url}/id/${id}`)
    }
  
  obtenerxnombre(nombre: string){
    return this.http.get<album[]>(`${this.url}/nombre/${nombre}`)
  }
  
  obtenerxestreno(estreno: number){
    return this.http.get<album[]>(`${this.url}/estreno/${estreno}`)
  }

  obtenerxartista(id: number){
    return this.http.get<album[]>(`${this.url}/artista/${id}`)
  }

  obtenerxcancion(id: number){
    return this.http.get<album[]>(`${this.url}/cancion/${id}`)
  }

  obtenerxdisquera(id: number){
    return this.http.get<album[]>(`${this.url}/disquera/${id}`)
  }
  
  crearalbum(nalbum: album){
    return this.http.post<album>(`${this.url}`, nalbum);
  }
  
  editaralbum(ealbum: album, id: number){
    return this.http.put<album>(`${this.url}/editar/${id}`,ealbum);
  }
  
  eliminaralbum(id: number){
    return this.http.delete<void>(`${this.url}/eliminar/${id}`);
  }
}
