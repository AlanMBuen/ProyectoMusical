import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-header',
  imports: [RouterLink],
  templateUrl: './header.html',
  styleUrl: './header.css',
})
export class Header {

  linksNav = [
    { ruta: '/1', texto: 'Inicio1'},
    { ruta: '/2', texto: 'Inicio2'},
    { ruta: '/3', texto: 'Inicio3'},
    { ruta: '/4', texto: 'Inicio4'}
  ]

  menuAbierto: boolean =false;
}
