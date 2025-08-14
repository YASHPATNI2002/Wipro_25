// Generic class Box<T>
var Box = /** @class */ (function () {
    function Box(value) {
        this.value = value;
    }
    // Method to get the stored value
    Box.prototype.getValue = function () {
        return this.value;
    };
    return Box;
}());
// Example usage:
// Box with a number
var numberBox = new Box(123);
console.log("Number Box Value:", numberBox.getValue()); // Output: 123
// Box with a string
var stringBox = new Box("Hello TypeScript");
console.log("String Box Value:", stringBox.getValue()); // Output: Hello TypeScript
// Box with a boolean
var booleanBox = new Box(true);
console.log("Boolean Box Value:", booleanBox.getValue()); // Output: true
