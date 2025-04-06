package com.abhishek.javainaction.chapter5.section5_3;

import com.abhishek.javainaction.utils.Dish;
import com.abhishek.javainaction.utils.DishList;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindingAndMatching {
    //The Streams API provides such facilities through the allMatch, anyMatch,
    //noneMatch, findFirst, and findAny methods of a stream.

    public static void main(String[] args) {
        List<Dish> menu = DishList.getDishList();
        exampleAnyMatch(menu);
        exampleAllMatch(menu);
        exampleNoneMatch(menu);
        exampleFindFirst(menu);
        exampleFindAny(menu);
        //When to use findFirst and findAny
        //You may wonder why we have both findFirst and findAny. The answer is parallelism. Finding
        //the first element is more constraining in parallel. If you don’t care about which element is
        //returned, use findAny because it’s less constraining when using parallel streams.

    }

    private static void exampleFindAny(List<Dish> menu) {
        //find any dish which is vegetarian
        Optional<Dish> dish = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();
        dish.ifPresent(System.out::println);

        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree =
                someNumbers.parallelStream()
                        .map(x -> x * x)
                        .filter(x -> x % 3 == 0)
                        .findAny();
        System.out.println(firstSquareDivisibleByThree);
    }

    private static void exampleFindFirst(List<Dish> menu) {
        //find first dish which is vegetarian
        Optional<Dish> dish = menu.stream()
                .filter(Dish::isVegetarian)
                .findFirst();
        dish.ifPresent(System.out::println);


        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree =
                someNumbers.stream()
                        .map(x -> x * x)
                        .filter(x -> x % 3 == 0)
                        .findFirst(); // 9
        System.out.println(firstSquareDivisibleByThree);
    }



    private static void exampleNoneMatch(List<Dish> menu) {
        //check if any dish which has more than 1000 calories.
        boolean isNotHealthyDishExist = menu.stream().allMatch(dish -> dish.getCalories()>=1000);
        System.out.println(isNotHealthyDishExist);
    }

    private static void exampleAllMatch(List<Dish> menu) {
        //you can use it to find out whether the menu is
        //healthy (that is, all dishes are below 1000 calories):
        boolean isHealthy = menu.stream().allMatch(dish -> dish.getCalories()<1000);
        System.out.println(isHealthy);
    }

    private static void exampleAnyMatch(List<Dish> menu) {
        //Check if any vegetarian dish is available in menu
        boolean anyMatchVeg = menu.stream().anyMatch(Dish::isVegetarian);
        System.out.println(anyMatchVeg);
    }


}
