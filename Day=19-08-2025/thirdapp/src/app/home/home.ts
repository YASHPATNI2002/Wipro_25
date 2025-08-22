import { Component } from '@angular/core';
import { IFruit } from '../fruit';
import { DisplayListComponent } from '../display-list/display-list';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [DisplayListComponent],
  templateUrl: './home.html',
  styleUrls: ['./home.css']
})
export class HomeComponent {
  fruits: IFruit[] = [
    { name: 'Apple', image: 'https://upload.wikimedia.org/wikipedia/commons/1/15/Red_Apple.jpg', description: 'A sweet red fruit rich in vitamins.' },
    { name: 'Banana', image: 'https://upload.wikimedia.org/wikipedia/commons/8/8a/Banana-Single.jpg', description: 'A yellow fruit full of potassium.' },
    { name: 'Orange', image: 'https://upload.wikimedia.org/wikipedia/commons/c/c4/Orange-Fruit-Pieces.jpg', description: 'A citrus fruit rich in Vitamin C.' }
  ];

  onRemove(fruitName: string) {
    this.fruits = this.fruits.filter(f => f.name !== fruitName);
     console.log("Removed fruit:", fruitName);
  }
}
