package com.wipro.solid;

class PaymentProcessor {
    private Payment paymentMethod;

    public PaymentProcessor(Payment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void makePayment(double amount) {
        paymentMethod.pay(amount);
    }
}
