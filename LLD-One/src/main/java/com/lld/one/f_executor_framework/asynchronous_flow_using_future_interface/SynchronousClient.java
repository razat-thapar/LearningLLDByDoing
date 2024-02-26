package com.lld.one.f_executor_framework.asynchronous_flow_using_future_interface;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SynchronousClient {
    public static void main(String[] args) {
        //Task is to store and print the pow(2,x) for x = [1,10] when a client submits it.
        //Now, we want to implement Synchronous flow !
        //i.e., client will wait for the execution to complete.
        //How ?
        // Normally
        // If some thread executes a task , it needs to be stored in a variable ,and we need to wait for it to complete.
        // i.e., Synchronous Flow
        for(int num=1;num<=10;num++){
            //create the task
            //submit the task.
            //store the response in an Integer.
            //print the value.
            PowerOfTwoRunnable task = new PowerOfTwoRunnable(num);
            Thread t1 = new Thread(task);
            t1.start();
            //blocking call!
            try {
                t1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Integer ans = task.getResult();
            System.out.println(ans);
            //Here, Client needs to wait for the current task to complete
            //and then execute another tasks.
            //Hence, it's a Synchronous Flow.
        }
    }
}
