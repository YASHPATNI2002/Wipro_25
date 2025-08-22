import { Component } from '@angular/core';
import { Task } from '../task';
import { TaskComponent } from '../task/task';
import { TaskListComponent } from '../task-list/task-list';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  templateUrl: './home.html',
  styleUrls: ['./home.css'],
  standalone: true,
  imports: [TaskComponent, TaskListComponent, CommonModule]
})
export class HomeComponent {
  tasks: Task[] = [];
  private nextId: number = 1;

  addTask(task: Task) {
    task.id = this.nextId++;
    this.tasks.push(task);
  }

  deleteTask(id: number) {
    this.tasks = this.tasks.filter(task => task.id !== id);
  }
}
