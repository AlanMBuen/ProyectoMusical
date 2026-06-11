import { HttpClient } from '@angular/common/http';
import {  inject, Injectable } from '@angular/core';
import { usuario } from '../Models/usuario.models';

@Injectable({
  providedIn: 'root',
})
export class Usuario {

  private url = ('http://localhost:8080/api/usuarios');
  private http= inject(HttpClient);

  obtenertodos(){
    return this.http.get<usuario[]>(`${this.url}`);
  }
}
