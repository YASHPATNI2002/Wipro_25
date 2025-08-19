import { Component } from '@angular/core';
import { CommonModule } from '@angular/common'; // needed for *ngFor

@Component({
  selector: 'ex10',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './ex10.html',
  styleUrls: ['./ex10.css']
})
export class Ex10 {
  names: string[] = ['Alice', 'Bob', 'Charlie', 'David', 'Eva'];
}
