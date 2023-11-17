package com.lld.one.f_executor_framework.runnables;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Instant start , end ;
        long timeElapsed;
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("Welcome to Number Printer : Task print 1 to 100 numbers %n");
        System.out.println("####################################################################");
        System.out.println("--------------------------------------------------------------------");

        //Scenario 1: No Multi-Threading , print 1 to 100 numbers

        System.out.printf("DEMO : Printing numbers with only 1 thread i.e., Main %n");
        start = Instant.now();
        for(int i=1;i<=100;i++){
            System.out.printf("Task %d submitted by : %s%n",i,Thread.currentThread().getName());
            new NumberPrinter(i).run();
        }
        end = Instant.now();
        timeElapsed = Duration.between(start,end).toMillis();
        System.out.printf("Total Time taken to complete the task: %d ms %n",timeElapsed);

        System.out.println("--------------------------------------------------------------------");
        System.out.println("####################################################################");
        System.out.println("--------------------------------------------------------------------");


        //Scenario 2: Using Fixed Size Thread pool in Executor framework to complete a task of printing 100 numbers using only 10 threads.


        ExecutorService es = Executors.newFixedThreadPool(10);
        //submit the task.
        System.out.printf("Welcome to Demo of Fixed Size Thread Pool : Printed by : %s %n",Thread.currentThread().getName());
        start = Instant.now();
        for(int i=1;i<=100;i++){
            System.out.printf("Task %d submitted by : %s%n",i,Thread.currentThread().getName());
            es.submit(new NumberPrinter(i));
        }
        //shutdown the executor service
        es.shutdown();
        System.out.printf("Shutdown initiated successfully by : %s %n %s %n",Thread.currentThread().getName(),es);
        try{
            es.awaitTermination(1,TimeUnit.SECONDS);
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }finally {
            end = Instant.now();
            timeElapsed = Duration.between(start,end).toMillis();
            System.out.printf("Total Time taken to complete the task: %d ms %n %s %n",timeElapsed,es);
        }

        System.out.println("--------------------------------------------------------------------");
        System.out.println("####################################################################");
        System.out.println("--------------------------------------------------------------------");

        //Scenario 3: Using Cached Thread Pool in Executor framework to complete a task of printing 100 numbers using only 10 threads.


        ExecutorService es2 = Executors.newCachedThreadPool();
        //submit the task.
        System.out.printf("Welcome to Demo of Cached Thread Pool : Printed by : %s %n",Thread.currentThread().getName());
        start = Instant.now();
        for(int i=1;i<=100;i++){
            System.out.printf("Task %d submitted by : %s%n",i,Thread.currentThread().getName());
            es2.submit(new NumberPrinter(i));
        }
        //shutdown the executor service.
        es2.shutdown();
        System.out.printf("Process ended successfully by : %s %n %s %n",Thread.currentThread().getName(),es2);
        try{
            es2.awaitTermination(1,TimeUnit.SECONDS);
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }finally {
            end = Instant.now();
            timeElapsed = Duration.between(start,end).toMillis();
            System.out.printf("Total Time taken to complete the task: %d ms %n %s %n",timeElapsed,es2);
        }
    }
}
