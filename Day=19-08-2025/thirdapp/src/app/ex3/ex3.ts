import { Component } from '@angular/core';
import { NgClass } from '@angular/common';
@Component({
  selector: 'app-ex3',
  standalone: true,
  imports: [NgClass],
  templateUrl: './ex3.html',
  styleUrls: ['./ex3.css']
})
export class Ex3 {

    flag1 = true;
  flag2 = false;

  getNgClass() {
    return {
      'app1': this.flag1,
      'app2': this.flag2
    };
  }
}
