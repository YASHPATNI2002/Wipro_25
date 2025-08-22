import { Component } from '@angular/core';
import { NgClass } from '@angular/common';

@Component({
  selector: 'app-ex2',
  standalone: true,
  imports: [NgClass],       
  templateUrl: './ex2.html',
  styleUrls: ['./ex2.css']
})
export class Ex2Component {
  flag1 = true;
  flag2 = false;
}
