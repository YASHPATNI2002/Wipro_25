import { Component } from '@angular/core';
import { Ex4Component } from './ex4/ex4';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [Ex4Component],
  template: `<app-ex4></app-ex4>`
})
export class AppComponent {}
