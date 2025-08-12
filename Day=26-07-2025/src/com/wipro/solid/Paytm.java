package com.wipro.solid;

class Paytm implements Payment {
    public void pay(double amount) {
        System.out.println("Paid "+ amount + " using Paytm.");
    }
}
