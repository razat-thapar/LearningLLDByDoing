package com.lld.one.f_executor_framework.callables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.printf("Process started by %s %n",Thread.currentThread().getName());
        ExecutorService es = Executors.newFixedThreadPool(5);
        List<Future<Double>> values = new ArrayList<>();
        for(int i=0;i<=10;i++){
            //define our task.
            Power2 task = new Power2(i);
            //submit it to service.
            values.add(es.submit(task));
            System.out.printf("Task :%d submitted by %s %n",i,Thread.currentThread().getName());
        }

        for(Future<Double> val : values){
            //print the powers of 2 from list.
            System.out.printf("Value is : %f submitted by %s %n",val.get(),Thread.currentThread().getName());
        }

        es.shutdown();

        //
    }
}
