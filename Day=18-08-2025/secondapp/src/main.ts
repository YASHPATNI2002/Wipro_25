import 'zone.js';
import { bootstrapApplication } from '@angular/platform-browser';
import { Home } from './app/home/home';

bootstrapApplication(Home)
  .catch(err => console.error(err));
