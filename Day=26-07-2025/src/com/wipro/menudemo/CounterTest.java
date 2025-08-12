package com.wipro.menudemo;

public class CounterTest {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(new CounterThread(counter));
        Thread t2 = new Thread(new CounterThread(counter));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count: " + counter.getCount()); 
    }
}