import { Component } from '@angular/core';
import { CommonModule } from '@angular/common'; // needed for *ngFor

@Component({
  selector: 'ex12',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './ex12.html',
  styleUrls: ['./ex12.css']
})
export class Ex12 {
  countries: string[] = ['India', 'USA', 'Japan', 'Germany', 'Australia']; // list of countries
  dropdownItems: string[] = []; // initially empty

  loadCountries() {
    this.dropdownItems = [...this.countries]; // populate dropdown
  }
}
