package com.wipro.menudemo;

import java.util.Arrays;
import java.util.List;

public class NameProcessor {
    public static void main(String[] args) throws InterruptedException {
        List<String> names = Arrays.asList("Amit", "Jayanta", "Esha", "Ravi", "Uma", "Kiran");

        Runnable capitalizeVowels = () -> {
            for (int i = 0; i < names.size(); i++) {
                String name = names.get(i);
                if (startsWithVowel(name)) {
                    names.set(i, name.toUpperCase());
                }
            }
        };

        Runnable lowercaseNonVowels = () -> {
            for (int i = 0; i < names.size(); i++) {
                String name = names.get(i);
                if (!startsWithVowel(name)) {
                    names.set(i, name.toLowerCase());
                }
            }
        };

        Thread t1 = new Thread(capitalizeVowels);
        Thread t2 = new Thread(lowercaseNonVowels);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final List: " + names);
    }

    private static boolean startsWithVowel(String name) {
        char first = Character.toUpperCase(name.charAt(0));
        return first == 'A' || first == 'E' || first == 'I' || first == 'O' || first == 'U';
    }
}
