import { Component } from '@angular/core';
import { NgStyle } from '@angular/common';

@Component({
  selector: 'app-ex4',
  standalone: true,
  imports: [NgStyle],
  templateUrl: './ex4.html',
  styleUrls: ['./ex4.css']
})
export class Ex4 {
  flag1 = true;
  color1 = 'green';
  fontSize1 = '20px';
}
