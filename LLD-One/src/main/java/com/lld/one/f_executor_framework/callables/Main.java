package com.lld.one.f_executor_framework.callables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
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
            try {
                System.out.printf("Value is : %f submitted by %s %n",val.get(),Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        shutdownAndAwaitTermination(es);

    }
    static void shutdownAndAwaitTermination(ExecutorService es){
        //disable new tasks from being submitted.
        es.shutdown();
        try{
            //wait a while for existing tasks to terminate
            if(! (es.awaitTermination(60, TimeUnit.SECONDS))){
                //forcefully cancel all executing tasks.
                es.shutdownNow();
                //wait a while for tasks to respond to being cancelled.
                if(! (es.awaitTermination(60,TimeUnit.SECONDS))){
                    System.err.println("executor service didn\'t terminate");
                }
            }
        }catch(InterruptedException e){
            //cancel if current thread also interrupted.
            es.shutdownNow();
        }
    }
}
