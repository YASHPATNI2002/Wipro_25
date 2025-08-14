// Generic function to create a tuple of two values
function pair(first, second) {
    return [first, second];
}
// Example usage:
var stringNumberPair = pair("Age", 25);
console.log("String-Number Pair:", stringNumberPair); // Output: ["Age", 25]
var booleanStringPair = pair(true, "Yes");
console.log("Boolean-String Pair:", booleanStringPair); // Output: [true, "Yes"]
var numberArrayPair = pair(10, [1, 2, 3]);
console.log("Number-Array Pair:", numberArrayPair); // Output: [10, [1, 2, 3]]
