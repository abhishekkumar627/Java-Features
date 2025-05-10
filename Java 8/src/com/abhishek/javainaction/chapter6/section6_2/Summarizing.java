package com.abhishek.javainaction.chapter6.section6_2;

import com.abhishek.javainaction.utils.Dish;
import com.abhishek.javainaction.utils.DishList;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;

public class Summarizing {
    public static void main(String[] args) {
        List<Dish> dishes = DishList.getDishList();

        totalCalories(dishes);
        avgCalories(dishes);
        allOperations(dishes);

    }

    private static void allOperations(List<Dish> dishes) {
        IntSummaryStatistics  menuStatistics = dishes.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics);
        System.out.println("count : "+menuStatistics.getCount());
        System.out.println("sum : "+menuStatistics.getSum());
        System.out.println("avg : "+menuStatistics.getAverage());
        System.out.println("min : "+menuStatistics.getMin());
        System.out.println("max : "+menuStatistics.getMax());

        LongSummaryStatistics menuStatistics2 = dishes.stream().collect(Collectors.summarizingLong(Dish::getCalories));
        System.out.println(menuStatistics2);
        System.out.println("count : "+menuStatistics2.getCount());
        System.out.println("sum : "+menuStatistics2.getSum());
        System.out.println("avg : "+menuStatistics2.getAverage());
        System.out.println("min : "+menuStatistics2.getMin());
        System.out.println("max : "+menuStatistics2.getMax());
    }

    private static void avgCalories(List<Dish> dishes) {
        double avgCalories = dishes.stream().collect(Collectors.averagingInt(Dish::getCalories));
        System.out.println("Average calories : "+avgCalories);
    }

    private static void totalCalories(List<Dish> dishes) {
        long totalCalories = dishes.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println("Total calories 1: "+totalCalories);

        long totalCalories2 = dishes.stream().mapToInt(Dish::getCalories).sum();
        System.out.println("Total calories 2: "+totalCalories2);

    }
}
