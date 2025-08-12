package com.wipro.solid;

public class DigitalPaymentTest {
    public static void main(String[] args) {
        Payment googlePay = new GooglePay();
        Payment phonePay = new PhonePay();
        Payment paytm = new Paytm();

        PaymentProcessor processor1 = new PaymentProcessor(googlePay);
        processor1.makePayment(1000);

        PaymentProcessor processor2 = new PaymentProcessor(phonePay);
        processor2.makePayment(500);

        PaymentProcessor processor3 = new PaymentProcessor(paytm);
        processor3.makePayment(750);
    }
}
