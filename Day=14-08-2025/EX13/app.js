// Import the User class from user.js
import { User } from './user.js';

// Create a User instance
const user1 = new User("Yash Patani");

// Display on the webpage
document.body.innerHTML += `<p>User Name: ${user1.getName()}</p>`;
