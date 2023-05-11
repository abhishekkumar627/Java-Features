package com.abhishek.methodreferences;

import java.util.function.BiFunction;

public class InstanceMethodReferences {
      public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> adder = new InstanceMethodReferences()::add;
        int result = adder.apply(10, 20);
        System.out.println(result);
    }
}

