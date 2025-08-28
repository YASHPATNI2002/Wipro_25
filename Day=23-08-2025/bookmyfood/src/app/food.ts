import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Food { id:number; name:string; category:string; price:number; available:boolean; imageUrl?:string; }

@Injectable({ providedIn: 'root' })
export class FoodService {
  private base = 'http://localhost:9999/FOOD-SERVICE';

  constructor(private http: HttpClient) {}

  list(): Observable<Food[]> {
    return this.http.get<Food[]>(`${this.base}/food`);
  }
}
