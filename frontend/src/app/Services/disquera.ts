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
}
