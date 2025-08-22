import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Task } from '../task';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.html',
  styleUrls: ['./task-list.css'],
  standalone: true,
  imports: [CommonModule]
})
export class TaskListComponent {
  @Input() tasks: Task[] = [];
  @Output() taskDeleted = new EventEmitter<number>();

  deleteTask(id: number) {
    this.taskDeleted.emit(id);
  }
}
