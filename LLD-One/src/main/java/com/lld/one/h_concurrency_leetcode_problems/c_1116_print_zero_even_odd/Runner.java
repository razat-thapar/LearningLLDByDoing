package com.lld.one.h_concurrency_leetcode_problems.c_1116_print_zero_even_odd;

import java.util.function.IntConsumer;

public class Runner {
    public static void main(String[] args) {
        //create an  instance of ZeroEvenOdd
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(2);
        //printNumber
        IntConsumer printNumber = (x) -> System.out.print(x);
        //create 3 newThreads and start them.
        new Thread(()->{
            try {
                zeroEvenOdd.even(printNumber);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()->{
            try {
                zeroEvenOdd.odd(printNumber);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()->{
            try {
                zeroEvenOdd.zero(printNumber);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
