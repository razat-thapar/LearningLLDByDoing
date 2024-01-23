package com.lld.one.k_streams_and_lambdas.d_solution2_lambdas.f_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // sorting a list using comparator .
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(6);
        arr.add(2);
        arr.add(-7);
        arr.add(18);
        Comparator<Integer> descending = (a,b) -> {
            if(a.intValue() > b.intValue()){
                return -1;
            }else if(a.intValue() < b.intValue()){
                return 1;
            }else{
                return 0;
            }
        };
        Collections.sort(arr,descending);
        System.out.println(arr);
    }
}
