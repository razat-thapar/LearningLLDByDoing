package com.lld.one.k_streams_and_lambdas.d_solution2_lambdas.c_predicate;

import java.util.function.Predicate;

public class Main3 {
    public static void main(String[] args) {
        int[] arr = {11,22,33,44,55,66,77,88,99};
        //Problem statement: Get all the even numbers from the array.
        //What if we now want odd numbers as well as sometimes even numbers from array?
        //appraoch 1: create separate methods based on requirements.
        getEven(arr);
        //appraoch 2: Using predicate + only 1 method with 2 arguments , predicate + array.
        Predicate<Integer> even = (num)-> num%2==0;
        getResult(even,arr);
        //using predicate methods negate(), or(), and()
        getResult(even.negate(),arr);
        //Requirement: Need to get even numbers and oddnumber above 50.
        Predicate<Integer> above50 = num-> num>50;
        getResult(even.negate().and(above50).or(even),arr);
    }
    public static void getResult(Predicate<Integer> p , int[] arr){
        for(int num : arr){
            if(p.test(num)){
                System.out.println(num);
            }
        }
        System.out.println("-------------------------------------");
    }
    public static void getEven(int[] arr){
        for(int num : arr){
            if(num%2==0){
                System.out.println(num);
            }
        }
        System.out.println("-------------------------------------");
    }
    public static void getOdd(int[] arr){
        for(int num : arr){
            if(num%2!=0){
                System.out.println(num);
            }
        }
        System.out.println("-------------------------------------");
    }
}
