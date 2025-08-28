import { Component } from '@angular/core';
import { RouterOutlet, Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AuthService } from './services/auth';

@Component({
  standalone: true,
  selector: 'app-root',
  imports: [RouterOutlet, CommonModule],
  templateUrl: './app.html'
})
export class AppComponent {
  constructor(private auth: AuthService, private router: Router) {}
  get isLoggedIn() { return this.auth.isLoggedIn; }
  logout() { this.auth.logout(); this.router.navigate(['/login']); }
}
