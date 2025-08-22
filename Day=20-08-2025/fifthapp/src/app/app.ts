import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CelsiusToFahrenheitPipe } from './celsius-to-fahrenheit-pipe';
import { HighlightStrikethruDirective } from './highlight-strikethru';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule,HighlightStrikethruDirective, FormsModule, CelsiusToFahrenheitPipe], 
  templateUrl: './app.html',
})
export class App {
  text = '';
  selectedDate: string = '';
  celsiusValue: number = 0;
}
