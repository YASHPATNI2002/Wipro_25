import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'ex9',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './ex9.html',
  styleUrls: ['./ex9.css']
})
export class Ex9 {
  myMessage: string = ""; // bound to input

  // Button click handler
  printMessage() {
    console.log("Input value:", this.myMessage);
  }
}
