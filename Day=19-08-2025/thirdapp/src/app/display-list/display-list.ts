import { Component, Input, Output, EventEmitter } from '@angular/core';
import { IFruit } from '../fruit';
import { CommonModule } from '@angular/common';  

@Component({
  selector: 'app-display-list',
  standalone: true,
  imports: [CommonModule],   
  templateUrl: './display-list.html',
  styleUrls: ['./display-list.css']
})
export class DisplayListComponent {
  @Input() items: IFruit[] = [];
  @Output() removeItem = new EventEmitter<string>();

  remove(fruitName: string) {
    this.removeItem.emit(fruitName);
  }
}
