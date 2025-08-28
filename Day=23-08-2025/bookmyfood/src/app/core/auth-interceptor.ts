// src/app/core/auth-interceptor.ts
import { inject } from '@angular/core';
import {
  HttpInterceptorFn
} from '@angular/common/http';
import { Router } from '@angular/router';
import { catchError, throwError } from 'rxjs';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
  const token = localStorage.getItem('token');

  // Only attach to calls going through your Gateway
  if (token && req.url.startsWith('http://localhost:9999/')) {
    const value = token.startsWith('Bearer ') ? token : `Bearer ${token}`;
    req = req.clone({
      setHeaders: { Authorization: value }
      // withCredentials: false // keep false unless you use cookies
    });
  }

  // Optional: handle 401s globally
  const router = inject(Router);
  return next(req).pipe(
    catchError(err => {
      if (err.status === 401) {
        localStorage.removeItem('token');
        router.navigate(['/login']);
      }
      return throwError(() => err);
    })
  );
};
