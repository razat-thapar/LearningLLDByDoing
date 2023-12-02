package com.lld.one.f_executor_framework.merge_sort_using_multithreading.runnables;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args){
        Instant start = Instant.now();
        //Scenario 1: MergeSort using Runnable interface.
        ExecutorService es = Executors.newCachedThreadPool();
        int[] arr = {5, 3, 1, 6, 9, -1, 523, 2,23,23,29,9,0,5, 3, 1, 6, 9, -1, 523, 2,23,23,29,9,0};
        Future f = es.submit(new MergeSort(arr,0,arr.length-1,es));
        //wait for task to complete.
        try {
            f.get();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        Instant end = Instant.now();
        System.out.printf("Total duration: %d ms %n", Duration.between(start,end).toMillis());

        //print
        for(int a: arr){
            System.out.printf("%d,",a);
        }
        System.out.println();
        es.shutdown();
    }
}
