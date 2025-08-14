// Array
const numbers = [1, 2, 3];

// Function that sums three numbers
function sum(a, b, c) {
    return a + b + c;
}

// Use spread operator
const total = sum(...numbers);

console.log("Sum:", total);
