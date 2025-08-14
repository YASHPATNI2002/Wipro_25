//EX22
// Generic Stack class
class Stack<T> {
    private items: T[] = [];

    // Add an item to the top of the stack
    push(item: T): void {
        this.items.push(item);
    }

    // Remove and return the top item from the stack
    pop(): T | undefined {
        return this.items.pop();
    }

    // Return the top item without removing it
    peek(): T | undefined {
        return this.items[this.items.length - 1];
    }

    // Optional: Return the current size of the stack
    size(): number {
        return this.items.length;
    }

    // Optional: Check if the stack is empty
    isEmpty(): boolean {
        return this.items.length === 0;
    }
}

// Example usage:

const numberStack = new Stack<number>();

numberStack.push(10);
numberStack.push(20);
numberStack.push(30);

console.log("Top item:", numberStack.peek()); // Output: 30
console.log("Popped item:", numberStack.pop()); // Output: 30
console.log("New top item:", numberStack.peek()); // Output: 20
console.log("Stack size:", numberStack.size()); // Output: 2
