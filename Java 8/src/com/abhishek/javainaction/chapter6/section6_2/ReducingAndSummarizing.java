package com.abhishek.javainaction.chapter6.section6_2;

import com.abhishek.javainaction.utils.Dish;
import com.abhishek.javainaction.utils.DishList;

import java.util.List;
import java.util.stream.Collectors;

public class ReducingAndSummarizing {

    public static void main(String[] args) {
        List<Dish> dishes = DishList.getDishList();

        countNoOfDishes(dishes);


    }

    private static void countNoOfDishes(List<Dish> dishes) {
        long count = dishes.stream().count();
        System.out.println(count);

        long count2 = dishes.stream().collect(Collectors.counting());
        System.out.println(count2);
    }

}
