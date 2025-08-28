import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FoodService } from '../../services/food';
import { Food } from '../../interfaces/food';

@Component({
  standalone: true,
  selector: 'app-food-list',
  imports: [CommonModule],
  templateUrl: './food-list.html'
})
export class FoodListComponent implements OnInit {
  foods: Food[] = [];
  loading = false;
  err = '';

  constructor(private api: FoodService) {}

  ngOnInit(): void {
    this.load();
  }

  load(): void {
    this.loading = true;
    this.err = '';
    this.api.list().subscribe({
      next: d => { this.foods = d; this.loading = false; },
      error: () => { this.err = 'Failed to load foods'; this.loading = false; }
    });
  }
}
