import { Component, signal } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { Header } from './Components/header/header';
import { HeaderSecundario } from './Components/header-secundario/header-secundario';
import { Footer } from './Components/footer/footer';
import { Home } from './Pages/home/home';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, RouterLink, Header, HeaderSecundario, Footer, Home],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('frontend');
}
