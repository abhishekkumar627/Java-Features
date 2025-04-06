package com.abhishek.javainaction.chapter5.section5_4;

import com.abhishek.javainaction.utils.Dish;
import com.abhishek.javainaction.utils.DishList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ReducingExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 5, 3, 9);
        List<Dish> menu= DishList.getDishList();
        classicSumMethod(numbers);
        usingStreamReduceMethod(numbers);
        getMaxUsingReduceMethod(numbers);
        getMinUsingReduceMethod(numbers);
        countNoOfDishes(menu);
    }

    private static void countNoOfDishes(List<Dish> menu) {
        int count = menu.stream()
                .map(dish -> 1)
                .reduce(0,Integer::sum);
        System.out.println(count);

        long count2 = menu.stream().count();
        System.out.println(count2);
    }

    private static void getMinUsingReduceMethod(List<Integer> numbers) {
        Optional<Integer> min= numbers.stream()
                .reduce(Integer::min);
        System.out.println("Min : "+ min);

        Integer min2= numbers.stream()
                .reduce(Integer.MAX_VALUE,(x,y)->x<y?x:y);
        System.out.println("Min : "+ min2);


    }

    private static void getMaxUsingReduceMethod(List<Integer> numbers) {
        Optional<Integer> max= numbers.stream()
                .reduce(Integer::max);
        System.out.println(max);

        Integer max2= numbers.stream()
                .reduce(Integer.MIN_VALUE,(x,y)->x>y?x:y);
        System.out.println("Max : "+ max2);

    }

    private static void usingStreamReduceMethod(List<Integer> numbers) {
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);

        //without identity

        Optional<Integer> sum2 = numbers.stream().reduce(Integer::sum);
        System.out.println(sum2);

    }

    private static void classicSumMethod(List<Integer> numbers) {
        int sum = 0;
        for (int k : numbers) {
            sum = sum + k;
        }
        System.out.println(sum);
    }
}
