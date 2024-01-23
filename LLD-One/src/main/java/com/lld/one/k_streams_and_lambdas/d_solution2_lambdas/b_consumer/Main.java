package com.lld.one.k_streams_and_lambdas.d_solution2_lambdas.b_consumer;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        // using consumer to iterate over arraylist.
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(i);
        }
        //iterating using foreach and printing each num in list.
        Consumer<Integer> action = (x) -> System.out.printf("num : %d%n",x);
        list.forEach(action);
    }
}
