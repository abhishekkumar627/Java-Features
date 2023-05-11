package com.abhishek.staticinterface;

public class Bmw implements Vehicle {
    public static void main(String[] args) {
        String b = Vehicle.producer();
        System.out.println(b);

        String b1 = Bmw.producer();
        System.out.println(b1);

    }

    public static String producer(){
        return "Inside Bmw";
    }

}
