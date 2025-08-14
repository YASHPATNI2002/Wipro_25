//EX22
// Generic Stack class
var Stack = /** @class */ (function () {
    function Stack() {
        this.items = [];
    }
    // Add an item to the top of the stack
    Stack.prototype.push = function (item) {
        this.items.push(item);
    };
    // Remove and return the top item from the stack
    Stack.prototype.pop = function () {
        return this.items.pop();
    };
    // Return the top item without removing it
    Stack.prototype.peek = function () {
        return this.items[this.items.length - 1];
    };
    // Optional: Return the current size of the stack
    Stack.prototype.size = function () {
        return this.items.length;
    };
    // Optional: Check if the stack is empty
    Stack.prototype.isEmpty = function () {
        return this.items.length === 0;
    };
    return Stack;
}());
// Example usage:
var numberStack = new Stack();
numberStack.push(10);
numberStack.push(20);
numberStack.push(30);
console.log("Top item:", numberStack.peek()); // Output: 30
console.log("Popped item:", numberStack.pop()); // Output: 30
console.log("New top item:", numberStack.peek()); // Output: 20
console.log("Stack size:", numberStack.size()); // Output: 2
