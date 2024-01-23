package com.lld.one.k_streams_and_lambdas.d_solution2_lambdas.d_function;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        //map .
        Map<String,Integer> hm = new HashMap<>();
        hm.put("Razat",5);
        hm.put("Rahul",5);
        hm.put("Scaler",6);
        //using Function<T,R> interface
        Function<String,Integer> generateMapping = (str) -> str.length();
        hm.computeIfAbsent("Academy",generateMapping);
        //print hashmap.
        System.out.println(hm);
    }
}
