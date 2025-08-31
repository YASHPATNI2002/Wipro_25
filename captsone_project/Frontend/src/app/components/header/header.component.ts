import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { CartService } from '../../services/cart.service';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

  cartItemCount = 0;

  constructor(
    public authService: AuthService, 
    private router: Router,
    private cartService: CartService
  ) {
    this.updateCartCount();
  }

  updateCartCount(): void {
    this.cartItemCount = this.cartService.getCartItemCount();
  }

  logout(): void {
    this.authService.logout();
    this.router.navigate(['/login']);
  }

}
