package com.abhishek.javainaction.chapter5.section5_7;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamFromFunctions {
    //The Streams API provides two static methods to generate a stream from a function:
    //Stream.iterate and Stream.generate.
    public static void main(String[] args) {

        System.out.println("===================USING ITERATE METHOD====================");

        usingIterateFunction();
        System.out.println("==========FIBONACCI SERIES==============");
        usingIterateFibonacciFunction();

        System.out.println("===================USING GENERATE METHOD====================");

        usingGenerateMethod();


    }

    private static void usingGenerateMethod() {
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;

            @Override
            public int getAsInt() {
                System.out.println("Inside get Int");
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        };

        IntStream.generate(fib).limit(10).forEach(System.out::println);
    }

    private static void usingIterateFibonacciFunction() {
        Stream.iterate(new int[]{0, 1}, t1 -> new int[]{t1[1], t1[0] + t1[1]})
                .limit(10)
                .forEach(t -> System.out.print("(" + t[0] + "," + t[1] + ")  "));

        System.out.println();

        Stream.iterate(new int[]{0, 1}, t1 -> new int[]{t1[1], t1[0] + t1[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);
    }

    private static void usingIterateFunction() {
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);
    }
}
