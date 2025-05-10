package com.abhishek.javainaction.chapter6.section6_2;

import com.abhishek.javainaction.utils.Dish;
import com.abhishek.javainaction.utils.DishList;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Reduction {
    public static void main(String[] args) {
        List<Dish> dishes = DishList.getDishList();
        totalCaloriesByReducing(dishes);
        highestCalorieDishByReducing(dishes);
    }

    private static void highestCalorieDishByReducing(List<Dish> dishes) {
        Optional<Dish> highestCalorieDish = dishes.stream().collect(Collectors.reducing(
                (d1,d2)->d1.getCalories()> d2.getCalories()?d1:d2
        ));
        System.out.println(highestCalorieDish.get());

        Optional<Dish> highestCalorieDish2 = dishes.stream().reduce((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2);
        System.out.println(highestCalorieDish2.get());
    }

    private static void totalCaloriesByReducing(List<Dish> dishes) {
        //It takes three arguments:
        // The first argument is the starting value of the reduction operation and will also be the value returned
        //in the case of a stream with no elements, so clearly 0 is the appropriate value in the case of a numeric
        //sum.
        // The second argument is the same function you used in section 6.2.2 to transform a dish into an int
        //representing its calorie content.
        // The third argument is a BinaryOperator that aggregates two items into a single value of the same
        //type. Here, it just sums two ints.
        int totalCalories = dishes.stream().collect(Collectors.reducing(
                0,Dish::getCalories,(i,j)->i+j
        ));
        System.out.println(totalCalories);

        int totalCalories2 = dishes.stream().map(Dish::getCalories).reduce(0, (i, j) -> i + j);
        System.out.println(totalCalories2);

        int totalCalories22 = dishes.stream().map(Dish::getCalories).reduce(0,Integer::sum);
        System.out.println(totalCalories22);

        //sum example using the reducing collector by using a
        //reference to the sum method of the Integer class instead of the lambda expression
        int totalCalories3= dishes.stream().collect(Collectors.reducing(0,Dish::getCalories,Integer::sum));
        System.out.println(totalCalories3);

        int totalCalories4 = dishes.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(totalCalories4);


    }
}
