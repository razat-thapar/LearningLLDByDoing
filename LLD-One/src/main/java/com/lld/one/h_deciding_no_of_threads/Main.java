package com.lld.one.h_deciding_no_of_threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        //Scenario 1: CPU intensive Tasks are high.
        //# of Threads in pool = no of CPU cores
        //since, 1 OS thread = 1 java thread , and we want min context switching during OS thread scheduling algorithms.

        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService es = Executors.newFixedThreadPool(coreCount);
        //submit the tasks.
        for(int i=0;i<100;i++){
            es.submit(new CpuIntensiveTask());
        }
        //shutdown
        try {
            es.shutdown();
            es.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Scenario 2: IO intensive Tasks are high.
        //# of Threads in Thread pool = much higher count for IO tasks.
        //Since, most of the threads will be in waiting state
        // for IO operations to complete where CPU is not involved.
        //Hence, it makes sense to use higher count of threads to keep CPU busy.
        int countOfThreads = 100;
        ExecutorService es2 = Executors.newFixedThreadPool(countOfThreads);
        //submit the tasks.
        for(int i=0;i<100;i++){
            es2.submit(new InputOutputIntensiveTask());
        }
        //shutdown
        try {
            es2.shutdown();
            es2.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
