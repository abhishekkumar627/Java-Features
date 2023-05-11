package com.abhishek.methodreferences;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArbitraryObjectParticularTypeMethodReference {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 3, 50, 24, 40, 2, 9, 18);
        List<Integer> sorted1 = numbers.stream()
                .sorted((a, b) -> a.compareTo(b)).collect(Collectors.toList());
        List<Integer> sorted2 = numbers.stream()
                .sorted(Integer::compareTo).collect(Collectors.toList());
        System.out.println(sorted1);
        System.out.println(sorted2);
        //the method reference is much easier to read and understand
    }
}
