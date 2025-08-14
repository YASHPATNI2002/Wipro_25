class BankAccount {
    constructor(accountNumber, balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    deposit(amount) {
        if (amount > 0) {
            this.balance += amount;
            console.log(`Deposited: $${amount}. New Balance: $${this.balance}`);
        } else {
            console.log("Deposit amount must be positive.");
        }
    }

    withdraw(amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            console.log(`Withdrew: $${amount}. New Balance: $${this.balance}`);
        } else if (amount > this.balance) {
            console.log("Insufficient balance.");
        } else {
            console.log("Withdrawal amount must be positive.");
        }
    }
}

// Demo
let account = new BankAccount("123456", 500);
console.log(`Account Number: ${account.accountNumber}, Initial Balance: $${account.balance}`);

account.deposit(200);
account.withdraw(100);
account.withdraw(700); // Insufficient
