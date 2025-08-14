// Function using rest operator to sum any number of arguments
function sumNumbers(...numbers) {
    return numbers.reduce((total, num) => total + num, 0);
}

console.log("Sum of 1, 2, 3:", sumNumbers(1, 2, 3));       // 6
console.log("Sum of 5, 10, 15, 20:", sumNumbers(5, 10, 15, 20)); // 50
console.log("Sum with no arguments:", sumNumbers());        // 0
