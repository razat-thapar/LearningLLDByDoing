package com.lld.one.k_streams_and_lambdas.d_solution2_lambdas.b_consumer;

import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Main2 {
    public static void main(String[] args) {
        //Consumer
        Consumer<Integer> printRandomNumberBetweenZeroToInput
                = (x) -> {
            Random random = new Random();
            System.out.printf("Random number between 0 and %d is : %d%n",x,random.nextInt(x+1));
        };
        printRandomNumberBetweenZeroToInput.accept(10);
        //BiConsumer
        BiConsumer<Integer,String> printRandomNumberBetweenInputToLengthOfString
                = (num,str) -> {
            Random random = new Random();
            System.out.printf("Random number between %d & string %s of length %d is : %d ",num,str,str.length(),num + random.nextInt(str.length()+1-num));
        };
        printRandomNumberBetweenInputToLengthOfString.accept(3,"RazatAggarwal");
    }
}
