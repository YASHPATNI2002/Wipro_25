import { Component } from '@angular/core';
import { CommonModule } from '@angular/common'; // needed for *ngIf

@Component({
  selector: 'ex11',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './ex11.html',
  styleUrls: ['./ex11.css']
})
export class Ex11 {
  showMessage: boolean = false;

  toggleMessage(event: Event) {
    this.showMessage = (event.target as HTMLInputElement).checked;
  }
}
