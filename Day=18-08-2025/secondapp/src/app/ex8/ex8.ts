import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms'; // needed for ngModel

@Component({
  selector: 'ex8', // used if you ever include manually
  standalone: true,
  imports: [FormsModule],
  templateUrl: './ex8.html',
  styleUrls: ['./ex8.css']
})
export class Ex8 {
  myMessage: string = "Hello! This is my first Angular variable display.";
}
