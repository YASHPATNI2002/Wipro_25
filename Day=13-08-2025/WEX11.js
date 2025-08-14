// Create date object for 13th August 2030
let date = new Date("2030-08-13");

// Array of week days
let days = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];

// Get day index (0 = Sunday, 1 = Monday, ...)
let dayIndex = date.getDay();

// Get day name
let dayName = days[dayIndex];

console.log("13th August 2030 falls on a " + dayName);
