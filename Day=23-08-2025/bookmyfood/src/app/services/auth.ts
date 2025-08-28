import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { tap } from 'rxjs/operators';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class AuthService {
  private baseUrl = 'http://localhost:9999/USERMGMTV2-MS';

  constructor(private http: HttpClient) {}

  login(creds: { email: string; passWord: string }): Observable<{ token: string }> {
    return this.http
      .post<{ token: string }>(`${this.baseUrl}/user/login`, creds)
      .pipe(tap(res => localStorage.setItem('token', res.token))); // raw JWT expected
  }

  logout(): void {
    localStorage.removeItem('token');
  }

  getToken(): string | null {
    return localStorage.getItem('token');
  }

  // 👇 getter so you can use `this.auth.isLoggedIn` (no parentheses)
  get isLoggedIn(): boolean {
    return !!this.getToken();
  }
}
