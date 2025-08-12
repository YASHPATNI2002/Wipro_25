package com.wipro.menudemo;

public class ThreadDemo {
    public static void main(String[] args) {

        // Thread 1: Print numbers from 1 to 10
        Thread numberThread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + " - Number: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        numberThread.setName("NumberThread");  // ✅ Naming the thread

        // Thread 2: Print alphabets from A to J
        Thread alphabetThread = new Thread(() -> {
            for (char c = 'A'; c <= 'J'; c++) {
                System.out.println(Thread.currentThread().getName() + " - Alphabet: " + c);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        alphabetThread.setName("AlphabetThread");  // ✅ Naming the thread

        // Start both threads
        numberThread.start();
        alphabetThread.start();
    }
}
