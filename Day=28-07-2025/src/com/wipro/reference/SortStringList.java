package com.wipro.reference;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortStringList {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Supriya", "Sanskruti", "Krushna", "Sangita");

        List<String> sortedNames = names.stream()
                                        .sorted(String::compareTo) 
                                        .collect(Collectors.toList());

        sortedNames.forEach(System.out::println);
    }
}
