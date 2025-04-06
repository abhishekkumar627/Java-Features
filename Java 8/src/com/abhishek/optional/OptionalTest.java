package com.abhishek.optional;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        //return an empty Optional
        Optional<String> optional1 = Optional.empty();
        System.out.println(optional1);
        //System.out.println(optional1.get());

        //Optional that contains a non-null value
        String str = "value";
        Optional<String> optional2 = Optional.of(str);
        System.out.println(optional2.get());

        //return an Optional with a specific value or an empty Optional if the parameter is null:
        Optional<String> optional3 = Optional.ofNullable(str);
        System.out.println(optional3);

        Optional<String> optional4 = Optional.ofNullable(null);
        System.out.println(optional4.orElse("null"));
    }
}
