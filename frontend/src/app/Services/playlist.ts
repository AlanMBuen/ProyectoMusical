import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { playlist } from '../Models/playlist.models';

@Injectable({
  providedIn: 'root',
})
export class Playlist {

  private url = ('http://localhost:8080/api/playlists');
  private http = inject(HttpClient);

  obtenertodos(){
    return this.http.get<playlist[]>(`${this.url}`);
  }

  obtenerxid(id: number){
    return this.http.get<playlist>(`${this.url}/id/${id}`)
  }

  obtenerxnombre(nombre: string){
    return this.http.get<playlist[]>(`${this.url}/nombre/${nombre}`)
  }

  crearplaylist(nplaylist: playlist){
    return this.http.post<playlist>(`${this.url}`, nplaylist);
  }

  editarplaylist(eplaylist: playlist, id: number){
    return this.http.put<playlist>(`${this.url}/editar/${id}`,eplaylist);
  }

  eliminarplaylist(id: number){
    return this.http.delete<void>(`${this.url}/eliminar/${id}`);
  }
}
