package com.abhishek.javainaction.chapter5.section5_7;

import java.util.Arrays;

public class StreamFromArrays {
    public static void main(String[] args) {
        int[] nums = {2,3,4,5,6,7,8,6};
        int sum = Arrays.stream(nums).sum();
        System.out.println(sum);
    }
}
