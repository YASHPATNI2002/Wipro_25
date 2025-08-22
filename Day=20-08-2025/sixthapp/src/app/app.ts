import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MovieComponent } from './movie/movie'; 

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, MovieComponent],
  templateUrl: './app.html',
})
export class App {}
