import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { disquera } from '../Models/disquera.models';

@Injectable({
  providedIn: 'root',
})
export class Disquera {

  private url = ('http://localhost:8080/api/disqueras');
  private http = inject(HttpClient);

  obtenertodos(){
    return this.http.get<disquera[]>(`${this.url}`)
  }

  obtenerxid(id: number){
    return this.http.get<disquera>(`${this.url}/id/${id}`)
  }

  obtenerxnombre(nombre: string){
    return this.http.get<disquera[]>(`${this.url}/nombre/${nombre}`)
  }

  obtenerxcreacion(creacion: number){
    return this.http.get<disquera[]>(`${this.url}/creacion/${creacion}`)
  }

  obtenerxartista(id: number){
    return this.http.get<disquera[]>(`${this.url}/artista/${id}`)
  }

  obtenerxalbum(id: number){
    return this.http.get<disquera[]>(`${this.url}/album/${id}`)
  }

  creardisquera(ndisquera: disquera){
    return this.http.post<disquera>(`${this.url}`, ndisquera);
  }

  editardisquera(edisquera: disquera, id: number){
    return this.http.put<disquera>(`${this.url}/editar/${id}`,edisquera);
  }

  eliminardisquera(id: number){
    return this.http.delete<void>(`${this.url}/eliminar/${id}`);
  }
}
