package com.abhishek.defaultmethod;

public class Nissan implements Vehicle{

    @Override
    public String getOverview() {
        return Vehicle.super.getOverview();
    }

    public static void main(String[] args) {
        Vehicle v = new Nissan();
        System.out.println(v.getOverview());
    }
}
