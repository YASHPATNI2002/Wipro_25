import { Injectable } from '@angular/core';
import { Product } from '../models/product.model';
import { CartItem } from '../models/cart-item.model';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private storageKey = 'cartItems';

  constructor() {}

  getCartItems(): CartItem[] {
    const items = localStorage.getItem(this.storageKey);
    return items ? JSON.parse(items) : [];
  }

  addToCart(product: Product): void {
    const items = this.getCartItems();
    const existingItem = items.find(item => item.product.id === product.id);

    if (existingItem) {
      existingItem.quantity += 1;
    } else {
      items.push({ product, quantity: 1 });
    }

    localStorage.setItem(this.storageKey, JSON.stringify(items));
  }

  updateQuantity(productId: number, quantity: number): void {
    const items = this.getCartItems();
    const item = items.find(i => i.product.id === productId);

    if (item) {
      item.quantity = quantity;
      localStorage.setItem(this.storageKey, JSON.stringify(items));
    }
  }

  removeFromCart(productId: number): void {
    let items = this.getCartItems();
    items = items.filter(item => item.product.id !== productId);
    localStorage.setItem(this.storageKey, JSON.stringify(items));
  }

  clearCart(): void {
    localStorage.removeItem(this.storageKey);
  }

  getCartItemCount(): number {
    const items = this.getCartItems();
    return items.reduce((total, item) => total + item.quantity, 0);
  }
}