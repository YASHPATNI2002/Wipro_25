import { Component } from '@angular/core';
import { ReactiveFormsModule, FormControl } from '@angular/forms';

@Component({
  selector: 'app-reverse-text',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './reverse-text.html',
  styleUrls: ['./reverse-text.css']
})
export class ReverseTextComponent {
  fName = new FormControl('');
  reversedValue: string = '';

  constructor() {
    this.fName.valueChanges.subscribe((value) => {
      if (value) {
        this.reversedValue = value.split('').reverse().join('');
      } else {
        this.reversedValue = '';
      }
    });
  }
}
