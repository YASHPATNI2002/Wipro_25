import { Component } from '@angular/core';
import { HomeComponent } from './home/home';   // ✅ import HomeComponent

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [HomeComponent],   // ✅ this is allowed since HomeComponent is standalone
  template: `<app-home></app-home>`,  // ✅ use selector
})
export class App{}
