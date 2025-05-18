package com.abhishek.javainaction.chapter6.section6_3;

import com.abhishek.javainaction.utils.CaloricLevel;
import com.abhishek.javainaction.utils.Dish;
import com.abhishek.javainaction.utils.DishList;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

public class Grouping {
    public static void main(String[] args) {
        List<Dish> dishes = DishList.getDishList();
        groupDishesByType(dishes);
        dishesByCaloricLevel(dishes);
        multiLevelGrouping(dishes);
        countingByGrouping(dishes);
        mostCaloricByType(dishes);


    }

    private static void mostCaloricByType(List<Dish> dishes) {
        Map<Dish.Type, Optional<Dish>> mostCaloricByType =
                dishes.stream()
                        .collect(groupingBy(Dish::getType,maxBy(comparingInt(Dish::getCalories))));
        Map<Dish.Type, Optional<Dish>> minCaloricByType2 =dishes.stream().collect(Collectors.groupingBy(Dish::getType,Collectors.minBy(Comparator.comparingInt(
                Dish::getCalories
        ))));
        System.out.println(mostCaloricByType);
        System.out.println(minCaloricByType2);
    }

    private static void countingByGrouping(List<Dish> dishes) {
        Map<Dish.Type, Long> typesCount = dishes.stream().collect(
                groupingBy(Dish::getType, Collectors.counting()));
        System.out.println(typesCount);
    }

    private static void multiLevelGrouping(List<Dish> dishes) {
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishByTypeAndCaloricLevel =
                dishes.stream().collect(
                        groupingBy(
                                Dish::getType,
                                groupingBy(
                                        dish -> {
                                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                            else return CaloricLevel.FAT;
                                        }
                                )
                        )
                );
        System.out.println(dishByTypeAndCaloricLevel);
    }

    private static void dishesByCaloricLevel(List<Dish> dishes) {
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = dishes.stream().collect(
                groupingBy(
                        dish -> {
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        }
                )
        );
        System.out.println(dishesByCaloricLevel);
    }

    private static void groupDishesByType(List<Dish> dishes) {
        Map<Dish.Type, List<Dish>> dishByTypes = dishes.stream().collect(groupingBy(Dish::getType));
        System.out.println(dishByTypes);
    }
}
