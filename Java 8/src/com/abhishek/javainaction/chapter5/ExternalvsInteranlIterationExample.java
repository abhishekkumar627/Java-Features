package com.abhishek.javainaction.chapter5;

import com.abhishek.javainaction.utils.Dish;
import com.abhishek.javainaction.utils.DishList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExternalvsInteranlIterationExample {
    public static void main(String[] args) {
        List<Dish> allDishs = DishList.getDishList();

        externalIterations(allDishs);
        internalIterations(allDishs);

    }

    private static void internalIterations(List<Dish> allDishs) {
        List<Dish> vegDishes = allDishs.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
        System.out.println(vegDishes);
    }

    private static void externalIterations(List<Dish> allDishs) {
        List<Dish> vegetarianDishes = new ArrayList<>();
        for (Dish d:allDishs) {
            if (d.isVegetarian()){
                vegetarianDishes.add(d);
            }
        }
        System.out.println(vegetarianDishes);
    }


}
