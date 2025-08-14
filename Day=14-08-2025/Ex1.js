let numbers = [5, 10, 15, 20, 25];

// Arrow function 
let sumArray = (arr) => arr.reduce((total, num) => total + num, 0);

let totalSum = sumArray(numbers);

console.log("Sum of numbers:", totalSum);
