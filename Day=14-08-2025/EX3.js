class Util {
    // a) Get today's date in dd-mm-YYYY format
    static getDate() {
        let today = new Date();
        let dd = String(today.getDate()).padStart(2, '0');
        let mm = String(today.getMonth() + 1).padStart(2, '0'); // Months start at 0
        let yyyy = today.getFullYear();
        return `${dd}-${mm}-${yyyy}`;
    }

    // b) Return value of PI
    static getPIValue() {
        return Math.PI;
    }

    // c) Convert Celsius to Fahrenheit 
    static convertC2F(celsius) {
        return (celsius * 9/5) + 32;
    }

    // d) Get first n Fibonacci numbers
    static getFibonacci(n) {
        if (n <= 0) return [];
        if (n === 1) return [0];
        let fib = [0, 1];
        for (let i = 2; i < n; i++) {
            fib.push(fib[i - 1] + fib[i - 2]);
        }
        return fib;
    }
}

// Demo in console
console.log("Today's Date:", Util.getDate());
console.log("Value of PI:", Util.getPIValue());
console.log("25°C in Fahrenheit:", Util.convertC2F(25));
console.log("First 5 Fibonacci numbers:", Util.getFibonacci(5));
