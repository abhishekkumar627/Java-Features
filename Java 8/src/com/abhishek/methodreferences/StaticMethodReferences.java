package com.abhishek.methodreferences;

import java.util.function.BiFunction;
import java.util.function.Function;

//Method reference can be used as a shorter and more readable alternative for a lambda expression
// that only calls an existing method. There are four variants of method references.
public class StaticMethodReferences {


    public static int addition(int a, int b){
        return (a + b);
    }

   public static void main(String[] args) {
       // 2. Method reference to a static method of a class
       Function<Integer, Double> sqrt = (Integer input) -> Math.sqrt(input);
       System.out.println(sqrt.apply(4));
       Function<Integer, Double> sqrtRef = Math::sqrt;
       System.out.println(sqrtRef.apply(4));

       BiFunction<Integer, Integer, Integer> functionLambda = (a, b) -> StaticMethodReferences.addition(a, b);
       System.out.println(functionLambda.apply(10, 20));

       BiFunction<Integer, Integer, Integer> function = StaticMethodReferences::addition;
       System.out.println(function.apply(10, 20));
   }
}
