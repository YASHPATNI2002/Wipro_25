import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth';

@Component({
  standalone: true,
  selector: 'app-login',
  imports: [CommonModule, FormsModule],
  templateUrl: './login.html',
  styleUrls: ['./login.css']
})
export class LoginComponent {
  creds = { email: '', passWord: '' };
  loading = false;
  err = '';

  constructor(private auth: AuthService, private router: Router) {}

  doLogin(form: NgForm) {
    if (form.invalid || this.loading) return;
    this.loading = true;
    this.err = '';

    this.auth.login(this.creds).subscribe({
      next: () => {
        this.loading = false;
        this.router.navigate(['/foods']);
      },
      error: (e) => {
        this.loading = false;
        this.err = e?.error?.message || 'Invalid credentials';
      }
    });
  }
}
