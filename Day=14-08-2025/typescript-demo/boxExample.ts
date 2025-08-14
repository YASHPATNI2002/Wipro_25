// Generic class Box<T>
class Box<T> {
    private value: T;

    constructor(value: T) {
        this.value = value;
    }

    // Method to get the stored value
    getValue(): T {
        return this.value;
    }
}

// Example usage:

// Box with a number
const numberBox = new Box<number>(123);
console.log("Number Box Value:", numberBox.getValue()); // Output: 123

// Box with a string
const stringBox = new Box<string>("Hello TypeScript");
console.log("String Box Value:", stringBox.getValue()); // Output: Hello TypeScript

// Box with a boolean
const booleanBox = new Box<boolean>(true);
console.log("Boolean Box Value:", booleanBox.getValue()); // Output: true
