package com.abhishek.javainaction.chapter6.section6_2;

import com.abhishek.javainaction.utils.Dish;
import com.abhishek.javainaction.utils.DishList;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MaximumAndMinimum {
    public static void main(String[] args) {
        List<Dish> dishes = DishList.getDishList();

        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);

        maximumCalorieDish(dishes,dishCaloriesComparator);
        minimumCalorieDish(dishes,dishCaloriesComparator);

    }

    private static void minimumCalorieDish(List<Dish> dishes, Comparator<Dish> dishCaloriesComparator) {
        Optional<Dish> minCalorieDish = dishes.stream().collect(Collectors.minBy(dishCaloriesComparator));
        System.out.println(minCalorieDish.get());
    }

    private static void maximumCalorieDish(List<Dish> dishes, Comparator<Dish> dishCaloriesComparator) {
        Optional<Dish> maxCalorieDish = dishes.stream().collect(Collectors.maxBy(dishCaloriesComparator));
        System.out.println(maxCalorieDish.get());
    }
}
