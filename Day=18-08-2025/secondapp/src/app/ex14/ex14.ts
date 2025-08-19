import { Component } from '@angular/core';
import { CommonModule } from '@angular/common'; 
import { FormsModule } from '@angular/forms';   // for ngModel

@Component({
  selector: 'ex14',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './ex14.html',
  styleUrls: ['./ex14.css']
})
export class Ex14 {
  names: string[] = ['Jayanta', 'Jayaram', 'Rahul', 'Suresh', 'Anita', 'Priya'];
  searchText: string = ''; // bind this to the search input

  get filteredNames(): string[] {
    if (!this.searchText) return this.names;
    const lowerSearch = this.searchText.toLowerCase();
    return this.names.filter(name => name.toLowerCase().includes(lowerSearch));
  }
}
