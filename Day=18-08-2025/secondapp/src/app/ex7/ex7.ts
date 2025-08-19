import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'ex7',
  standalone: true,
  imports: [CommonModule],   
  templateUrl: './ex7.html',
  styleUrls: ['./ex7.css']
})
export class ex7 {
  myMessage: string = "Hello! This is my first Angular variable display.";
}
