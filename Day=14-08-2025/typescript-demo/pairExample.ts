// Generic function to create a tuple of two values
function pair<T, U>(first: T, second: U): [T, U] {
    return [first, second];
}

// Example usage:
const stringNumberPair = pair<string, number>("Age", 25);
console.log("String-Number Pair:", stringNumberPair); // Output: ["Age", 25]

const booleanStringPair = pair<boolean, string>(true, "Yes");
console.log("Boolean-String Pair:", booleanStringPair); // Output: [true, "Yes"]

const numberArrayPair = pair<number, number[]>(10, [1, 2, 3]);
console.log("Number-Array Pair:", numberArrayPair); // Output: [10, [1, 2, 3]]
