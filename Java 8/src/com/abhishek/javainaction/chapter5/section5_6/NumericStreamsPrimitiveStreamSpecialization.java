package com.abhishek.javainaction.chapter5.section5_6;

import com.abhishek.javainaction.utils.Dish;
import com.abhishek.javainaction.utils.DishList;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStreamsPrimitiveStreamSpecialization {
    //Primitive specialization
    //IntStream,DoubleStream, and LongStream
    //specialized version are mapToInt,mapToDouble, and mapToLong.
    //primitive
    //stream specializations: OptionalInt, OptionalDouble, and OptionalLong.

    //Primitive stream specializations

    public static void main(String[] args) {
        List<Dish> menu = DishList.getDishList();
        getSumOfCalories(menu);
        getMaxOfCalories(menu);
    }

    private static void getMaxOfCalories(List<Dish> menu) {
        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        System.out.println(maxCalories.orElse(0));
    }

    private static void getSumOfCalories(List<Dish> menu) {
        int sum = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println(sum);

        //converting numeric stream back to Stream of Integer.
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();

    }
}
