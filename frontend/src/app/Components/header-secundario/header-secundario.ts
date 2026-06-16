import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-header-secundario',
  imports: [RouterLink],
  templateUrl: './header-secundario.html',
  styleUrl: './header-secundario.css',
})
export class HeaderSecundario {
  menuAbierto: Boolean =false;
}
