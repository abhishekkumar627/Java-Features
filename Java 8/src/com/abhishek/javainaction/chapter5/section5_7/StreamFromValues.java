package com.abhishek.javainaction.chapter5.section5_7;

import java.util.stream.Stream;

public class StreamFromValues {
    public static void main(String[] args) {
        Stream<String> values = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
        values.map(String::toUpperCase).forEach(System.out::println);

        Stream<String> emptyStream = Stream.empty();
        System.out.println(emptyStream);
    }
}
