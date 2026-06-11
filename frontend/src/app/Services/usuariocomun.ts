import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { usuariocomun } from '../Models/usuariocomun.models';

@Injectable({
  providedIn: 'root',
})
export class Usuariocomun {

  private url = ('http://localhost:8080/api/usuarioscomunes');
  private http = inject(HttpClient);

  obtenertodos(){
    return this.http.get<usuariocomun[]>(`${this.url}`);
  }

}
