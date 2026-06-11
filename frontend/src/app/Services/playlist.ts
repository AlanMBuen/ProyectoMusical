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
}
