import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Secondcomp } from './secondcomp/secondcomp';
import { Login } from './login/login';
import { Thirdcomp } from './thirdcomp/thirdcomp';

@Component({
  selector: 'app-root',
  imports: [Secondcomp,Login,Thirdcomp],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('firstapp');
}
