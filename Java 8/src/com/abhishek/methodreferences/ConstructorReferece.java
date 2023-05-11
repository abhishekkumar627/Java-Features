package com.abhishek.methodreferences;
public class ConstructorReferece {

    ConstructorReferece(String test){
        System.out.println(test);
    }

    public static void main(String[] args) {
        ContructorRef c = ConstructorReferece::new;
        c.get("test");
    }
}
interface ContructorRef{
    ConstructorReferece get(String str);
}
