package com.abhishek.defaultmethod;

public interface Vehicle {

    static String producer(){
        return "Amazing vehicles";
    }

    default String getOverview(){
        return "Vehicle : " + producer();
    }

}
