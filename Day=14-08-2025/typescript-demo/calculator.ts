class Calculator {
    // Method to add two numbers
    add(a: number, b: number): number {
        return a + b;
    }

    // Method to subtract two numbers
    subtract(a: number, b: number): number {
        return a - b;
    }
}

// Example usage:
const calc = new Calculator();

console.log("5 + 3 =", calc.add(5, 3));       // Output: 8
console.log("10 - 7 =", calc.subtract(10, 7)); // Output: 3
