package com.abhishek.javainaction.chapter5;

import com.abhishek.javainaction.utils.Dish;
import com.abhishek.javainaction.utils.DishList;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class MappingExample1 {
    public static void main(String[] args) {
        //(the word mapping is used because it has a
        //meaning similar to transforming but with the nuance of “creating a new version of” rather than
        //“modifying”)

        List<Dish> menu = DishList.getDishList();
        exampleMapping1(menu);
        exampleMapping2();
        exampleMapping3(menu);
    }

    private static void exampleMapping3(List<Dish> menu) {
        //get name of dish and length of dish name
        List<Integer> lengthOfWords = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());
        System.out.println(lengthOfWords);
    }

    private static void exampleMapping2() {
        //Find length of each word
        List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
        List<Integer> lengthOfWords = words.stream().map(String::length).collect(toList());
        System.out.println(lengthOfWords);
    }

    private static void exampleMapping1(List<Dish> menu) {
        //get name of each dish
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(toList());
        System.out.println(dishNames);

    }
}
