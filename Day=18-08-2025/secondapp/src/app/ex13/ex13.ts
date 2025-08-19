import { Component } from '@angular/core';
import { CommonModule } from '@angular/common'; // needed for *ngFor
import { FormsModule } from '@angular/forms';   // needed for ngModel

@Component({
  selector: 'ex13',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './ex13.html',
  styleUrls: ['./ex13.css']
})
export class Ex13 {
  colors: string[] = ['red', 'green', 'blue', 'orange', 'purple'];
  selectedColor: string = 'black'; // default color
}
