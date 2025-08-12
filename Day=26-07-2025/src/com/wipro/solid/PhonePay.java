package com.wipro.solid;

class PhonePay implements Payment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Phone Pay.");
    }
}
