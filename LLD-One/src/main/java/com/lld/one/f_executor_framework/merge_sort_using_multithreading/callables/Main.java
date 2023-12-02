package com.lld.one.f_executor_framework.merge_sort_using_multithreading.callables;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args){
        //Scenario 1: Fixed size thread pool.
        //Problem: no available threads to take new tasks.
//        try {
//            ExecutorService es = Executors.newFixedThreadPool(5);
//            int[] arr = {5, 3, 1, 6, 9, -1, 523, 2};
//            int[] sorted_arr = es.submit(new MergeSort(arr, 0, arr.length - 1, es)).get();
//            //print.
//            for (int i : sorted_arr) {
//                System.out.printf("%d,", i);
//            }
//            System.out.println();
//        }catch(ExecutionException e){
//            System.out.println(e.getMessage());
//        }catch(InterruptedException e){
//            System.out.println(e.getMessage());
//        }finally{
//            es.shutdown();
//        }
        //Scenario 2 : Cached Thread pool.
        ExecutorService es=null;
        try{
            Instant start = Instant.now();
            es=Executors.newCachedThreadPool();
            int[] arr = {5, 3, 1, 6, 9, -1, 523, 2,23,23,29,9,0,5, 3, 1, 6, 9, -1, 523, 2,23,23,29,9,0};
            int[] sorted_arr = es.submit(new MergeSort(arr, 0, arr.length-1, es)).get();
            Instant end = Instant.now();
            System.out.printf("Total duration: %d ms %n", Duration.between(start,end).toMillis());
            //print.
            for (int i : sorted_arr) {
                System.out.printf("%d,", i);
            }
            System.out.println();
        }catch(ExecutionException | InterruptedException e){
            System.out.println(e.getMessage());
        }finally{
            es.shutdown();
        }
    }
}
