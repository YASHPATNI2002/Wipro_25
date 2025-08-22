import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Task } from '../task';

@Component({
  selector: 'app-task',
  templateUrl: './task.html',
  styleUrls: ['./task.css'],
  standalone: true,
  imports: [FormsModule]
})
export class TaskComponent {
  description: string = '';
  category: string = '';

  @Output() taskAdded = new EventEmitter<Task>();

  addTask() {
    if (this.description && this.category) {
      this.taskAdded.emit({ description: this.description, category: this.category });
      this.description = '';
      this.category = '';
    } else {
      alert('Please enter description and category');
    }
  }
}
