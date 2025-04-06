package com.abhishek.javainaction.chapter5;

import com.abhishek.javainaction.utils.Dish;
import com.abhishek.javainaction.utils.DishList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilteringSlicingExample {
    public static void main(String[] args) {
        List<Dish> dishes = DishList.getDishList();
        exampleType1(dishes);
        exampleType2();
        exampleType3(dishes);
        exampleType4(dishes);
        exampleType5(dishes);

    }

    private static void exampleType5(List<Dish> dishes) {
        //Filter first 2 meat dishes
        List<Dish> meatDishes = dishes.stream()
                .filter(dish -> dish.getType().equals(Dish.Type.MEAT))
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(meatDishes);
    }

    private static void exampleType4(List<Dish> dishes) {
        //Skipping elements
        List<Dish> menu = dishes.stream()
                .filter(dish -> dish.getCalories()>300)
                .skip(2)
                .collect(Collectors.toList());
        System.out.println(menu);
    }

    private static void exampleType3(List<Dish> dishes) {
        //Truncating a stream
        //Get dishes with more than 300 calories
        //Get first 3 only
        List<Dish> menu = dishes.stream()
                .filter(dish->dish.getCalories()>300)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(menu);
    }

    private static void exampleType2() {
        //Filtering unique elements
        //filtering even numbers with no duplicates
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream().filter(i->i%2==0)
                .distinct()
                .forEach(System.out::println);
    }

    private static void exampleType1(List<Dish> dishes) {
        //Filtering with a predicate
        List<Dish> vegDishes = dishes.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
        System.out.println(vegDishes);
    }
}
