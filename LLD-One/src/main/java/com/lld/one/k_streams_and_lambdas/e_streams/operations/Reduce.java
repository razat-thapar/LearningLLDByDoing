package com.lld.one.k_streams_and_lambdas.e_streams.operations;

import java.util.Arrays;
import java.util.List;

public class Reduce {
    public static void main(String[] args) {
        //Reduce. : A Terminal Operation
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
        //Purpose: to Reduce the elements of a stream to single element.
        int sum = nums.stream().reduce(0,(num1,num2)-> num1+num2);
        //steps:
        //1. For every element in stream.
        //2. we are passing identity, input element to lambda (binary operator)
        //3. finally, our stream will have only 1 element.
        //NOTE: Original list is not modified.
        System.out.println(nums);
        System.out.printf("Sum of all numbers in above list is %d",sum);
    }
}
