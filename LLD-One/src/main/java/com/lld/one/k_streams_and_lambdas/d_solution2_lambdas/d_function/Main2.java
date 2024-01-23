package com.lld.one.k_streams_and_lambdas.d_solution2_lambdas.d_function;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main2 {
    public static void main(String[] args) {
        //Function
        Function<String,Integer> sizeOfString = (str) -> { return str.length();};
        System.out.printf("The Size of string: %s is : %d%n","Razat",sizeOfString.apply("Razat"));
        //BiFunction
        BiFunction<String,String,Integer> maxSizeAmongPair = (str1,str2) -> {return Math.max(str1.length(),str2.length());};
        System.out.printf("The max length of string among : %s & %s  is : %d","Razat","Aggarwal",maxSizeAmongPair.apply("Razat","Aggarwal"));
    }
}
