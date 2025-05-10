package com.abhishek.javainaction.chapter6.section6_2;

import com.abhishek.javainaction.utils.Dish;
import com.abhishek.javainaction.utils.DishList;

import java.util.List;
import java.util.stream.Collectors;

public class Joining {
    public static void main(String[] args) {
        List<Dish> dishes = DishList.getDishList();

        joiningStrings(dishes);
    }

    private static void joiningStrings(List<Dish> dishes) {
        String shortMenu = dishes.stream().map(Dish::getName).collect(Collectors.joining());
        System.out.println(shortMenu);

        String shortMenuWithComma = dishes.stream().map(Dish::getName).collect(Collectors.joining(","));
        System.out.println(shortMenuWithComma);
    }

}
