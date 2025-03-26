package com.abhishek.javainaction.chapter4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        List<Dish> dishes = DishList.getDishList();
        System.out.println();

        ask1(dishes);
        ask2(dishes);
        ask3(dishes);
        ask4(dishes);
        ask5(dishes);



    }

    private static void ask5(List<Dish> dishes) {

        //intermediate and terminal operations
        System.out.println("====================Intermediate operations output====================");
        List<String> names = dishes.stream()
                .filter(dish -> {
                    System.out.println("filtering : "+ dish.getName());
                    return dish.getCalories()<400;
                })
                .map(dish -> {
                    System.out.println("mapping :"+dish.getName());
                    return dish.getName();
                })
                .limit(2)
                .collect(Collectors.toList());

        System.out.println(names);
    }

    private static void ask4(List<Dish> dishes) {
        //stream is only traversable once
        Stream<Dish> dishStream=dishes.stream();
        List<String> names = dishStream.map(Dish::getName).collect(Collectors.toList());
        System.out.println("============================ Dish Names =============================================");
        System.out.println(names);

        System.out.println("========================== Reusing Stream gives exception =============================================");
        //List<String> names2 = dishStream.map(Dish::getName).collect(Collectors.toList());
        //System.out.println(names2);
        //java.lang.IllegalStateException: stream has already been operated upon or closed

    }

    private static void ask3(List<Dish> dishes) {
        //select dishes which are less than 400 calories
        //get the names of the dishes
        //select only 2 dishes
        //get the list of all the dish names
        List<String> namesOfDishes =
                dishes.stream()
                        .filter(dish->dish.getCalories()<400)
                        .map(dish -> dish.getName())
                        .limit(2)
                        .collect(Collectors.toList());
        System.out.println("==============Dish with less than 400 calories names with only 2 dishes=============");
        System.out.println(namesOfDishes);
    }

    private static void ask2(List<Dish> dishes) {
        //group dishes by its type
        Map<Dish.Type,List<Dish>> groupingByType
                = dishes.stream().collect(Collectors.groupingBy(Dish::getType));
        System.out.println();
        System.out.println("====================Grouping Dishes by its type=======================");
        System.out.println(groupingByType);
    }

    private static void ask1(List<Dish> dishes) {
        //select dishes which are less than 400 calories
        //sort them by calories
        //get the names of the dishes
        //get the list of all the dish names
        System.out.println("Doing without stream first");
        normalWithoutStream(dishes);
        System.out.println();
        System.out.println();

        System.out.println("Doing with stream now");
        withStream(dishes);
        System.out.println();
        System.out.println();

        System.out.println("Doing with Parallel Stream now");
        withParallelStream(dishes);
    }

    private static void withParallelStream(List<Dish> dishes) {
        //select dishes which are less than 400 calories
        //sort them by calories
        //get the names of the dishes
        //get the list of all the dish names
        List<String> namesOfDishes = dishes.parallelStream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println("=========WITH PARALLEL STREAMS : Dishes with less than 400 calories sorted with names =========");
        System.out.println(namesOfDishes);
    }

    private static void withStream(List<Dish> dishes) {
        //select dishes which are less than 400 calories
        //sort them by calories
        //get the names of the dishes
        //get the list of all the dish names
        List<String> namesOfDishes = dishes.stream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(dish -> dish.getCalories()))
                .map(dish -> dish.getName())
                .collect(Collectors.toList());
        System.out.println("=========WITH STREAMS : Dishes with less than 400 calories sorted with names =========");
        System.out.println(namesOfDishes);
    }

    private static void normalWithoutStream(List<Dish> dishes) {
        //select dishes which are less than 400 calories
        //sort them by calories
        //get the names of the dishes
        //get the list of all the dish names

        //1. select dishes which are less than 400 calories
        List<Dish> withLessThan400Calories = new ArrayList<>();
        for (Dish dish : dishes) {
            if (dish.getCalories() < 400) {
                withLessThan400Calories.add(dish);
            }
        }
        System.out.println("=========NORMAL WITHOUT STREAMS : Dishes with less than 400 calories=========");
        System.out.println(withLessThan400Calories);
        System.out.println();

        //2. sort dishes which are less than 400 calories

        withLessThan400Calories.sort(new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });
        System.out.println("=========NORMAL WITHOUT STREAMS : Sorted Dishes with less than 400 calories=========");
        System.out.println(withLessThan400Calories);
        System.out.println();

        //get the names of the dishes
        List<String> namesOfDishes = new ArrayList<>();
        for (Dish dish : withLessThan400Calories) {
            namesOfDishes.add(dish.getName());
        }
        System.out.println("=========NORMAL WITHOUT STREAMS : Sorted Dishes with less than 400 calories names=========");
        System.out.println(namesOfDishes);
        System.out.println("===========================================================================================");

    }
}
