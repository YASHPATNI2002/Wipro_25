import { Routes } from '@angular/router';
import { AuthGuard } from './core/auth-guard';
import { LoginComponent } from './components/login/login';
import { FoodListComponent } from './components/food-list/food-list';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'foods', component: FoodListComponent, canActivate: [AuthGuard] },
  { path: '', pathMatch: 'full', redirectTo: 'foods' },
  { path: '**', redirectTo: 'foods' }
];
