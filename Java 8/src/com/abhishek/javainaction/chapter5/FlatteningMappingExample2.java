package com.abhishek.javainaction.chapter5;

import java.net.Inet4Address;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatteningMappingExample2 {


    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello","World");

        //return list of unique characters
        List<String[]> outcome = words.stream().map(word->word.split(""))
                .distinct().collect(Collectors.toList());
        System.out.println(outcome);
        //problem it return List<String[]>


        List<Stream<String>> outcome1 = words.stream().map(word->word.split(""))
                .map(Arrays::stream)
                .distinct().collect(Collectors.toList());
        System.out.println(outcome1);
        //problem it return List<Stream<String>>


        List<String> outcome2 = words.stream().map(word->word.split(""))
                .flatMap(Arrays::stream)
                .distinct().collect(Collectors.toList());
        System.out.println(outcome2);
        //flatmap flattens each generated stream to single stream.
        //the flatMap method lets you replace each value of a stream with another stream
        //and then concatenates all the generated streams into a single stream.

        //Given a list of numbers, how would you return a list of the square of each number? For
        //example, given [1, 2, 3, 4, 5] you should return [1, 4, 9, 16, 25].
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        List<Integer> squareNo = numbers.stream()
                .map(x->x*x)
                .collect(Collectors.toList());
        System.out.println(squareNo);

        //2. Given two lists of numbers, how would you return all pairs of numbers? For example, given a
        //list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]. For
        //simplicity, you can represent a pair as an array with two elements.

        List<Integer> num1 = Arrays.asList(1,2,3);
        List<Integer> num2 = Arrays.asList(3,4);
        List<int[]> pairs = num1.stream()
                .flatMap(x->num2.stream().map(y->new int[]{x,y}))
                .collect(Collectors.toList());

        for (int[] a :pairs) {
            System.out.print(Arrays.toString(a)+" ");
        }

        //3. How would you extend the previous example to return only pairs whose sum is divisible by 3?
        //For example, (2, 4) and (3, 3) are valid.

        List<int[]> pairs2 = num1.stream()
                .flatMap(x->num2.stream()
                        .filter(y->(x+y)%3==0)
                        .map(y->new int[]{x,y}))
                .collect(Collectors.toList());
        System.out.println();
        for (int[] a :pairs2) {
            System.out.print(Arrays.toString(a)+" ");
        }





    }
}
