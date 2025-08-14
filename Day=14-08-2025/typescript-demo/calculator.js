var Calculator = /** @class */ (function () {
    function Calculator() {
    }
    // Method to add two numbers
    Calculator.prototype.add = function (a, b) {
        return a + b;
    };
    // Method to subtract two numbers
    Calculator.prototype.subtract = function (a, b) {
        return a - b;
    };
    return Calculator;
}());
// Example usage:
var calc = new Calculator();
console.log("5 + 3 =", calc.add(5, 3)); // Output: 8
console.log("10 - 7 =", calc.subtract(10, 7)); // Output: 3
