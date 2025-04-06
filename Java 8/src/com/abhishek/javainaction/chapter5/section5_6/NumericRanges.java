package com.abhishek.javainaction.chapter5.section5_6;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericRanges {
    // Java 8 introduces two
    // static methods available on IntStream and LongStream
    // to help generate such ranges: range and
    // rangeClosed.

    //range is exclusive, whereas rangeClosed is inclusive

    public static void main(String[] args) {
        IntStream evenNumbers = IntStream.range(1, 100)
                .filter(n -> n % 2 == 0);
        System.out.println(evenNumbers.count());

        IntStream evenNumbers2 = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);
        System.out.println(evenNumbers2.count());

        pythagorasExample();
        pythagorasExample2();
    }

    private static void pythagorasExample2() {
        Stream<double[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a ->
                                IntStream.rangeClosed(a, 100)
                                        .mapToObj(
                                                b -> new double[]{
                                                        a, b, Math.sqrt(a * a + b * b)
                                                }
                                        )
                                        .filter(b -> b[2] % 1 == 0)
                        );


        pythagoreanTriples.limit(5)
                .forEach(t ->
                        System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
    }

    private static void pythagorasExample() {

        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a ->
                                IntStream.rangeClosed(a, 100)
                                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                        .mapToObj(
                                                b -> new int[]{
                                                        a, b, (int) Math.sqrt(a * a + b * b)
                                                }
                                        )


                        );


        pythagoreanTriples.limit(5)
                .forEach(t ->
                        System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
    }

}
