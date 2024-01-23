package com.lld.one.k_streams_and_lambdas.d_solution2_lambdas.c_predicate;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Main2 {
    public static void main(String[] args) {
        //Predicate
        Predicate<String> isOddLength = (str) -> { return str.length()%2!=0?true:false;};
        System.out.printf("Is string: %s an odd length string ? : %b%n","Razat",isOddLength.test("Raaz"));
        //BiPredicate
        BiPredicate<Integer,Integer> isOddSum = (num1,num2) -> { return (num1+num2)%2!=0?true:false;};
        System.out.printf("Is sum of %d & %d an odd sum ? : %b",1,3,isOddSum.test(1,3));
    }
}
