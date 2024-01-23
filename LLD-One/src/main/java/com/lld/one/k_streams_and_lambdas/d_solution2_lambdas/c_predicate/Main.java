package com.lld.one.k_streams_and_lambdas.d_solution2_lambdas.c_predicate;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // using consumer to iterate over arraylist.
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(i);
        }
        //filtering data based on predicate
        //filtering even values in list.
        Predicate<Integer> filter = (x) -> {
            boolean b = (x%2)==0 ? true : false;
            return b;
        };
        list.removeIf(filter);
        System.out.println(list);

    }
}
