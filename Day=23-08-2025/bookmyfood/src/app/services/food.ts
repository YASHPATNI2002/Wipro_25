import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Food } from '../interfaces/food';

@Injectable({ providedIn: 'root' })
export class FoodService {
  private baseUrl = 'http://localhost:9999/FOOD-SERVICE';
  constructor(private http: HttpClient) {}
  list(): Observable<Food[]> {
    return this.http.get<Food[]>(`${this.baseUrl}/food`);
  }
}
