package com.lld.one.f_executor_framework.asynchronous_flow_using_future_interface;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsynchronousClient {
    public static void main(String[] args) {
        //Task is to store and print the pow(2,x) for x = [1,10] when a client submits it.
        //Now, we want to implement Asynchronous flow !
        //i.e., client will not wait for the execution to complete.
        //How ?
        // Normally
        // If some thread executes a task , it needs to be stored in a variable ,and we need to wait for it to complete.
        // i.e., Synchronous Flow
        // Fix
        // Store the response in a Future<E> instead of a normal variable.
        ExecutorService es = Executors.newFixedThreadPool(4);
        List<Future<Integer>> futureList = new ArrayList<>();
        for(int num=1;num<=10;num++){
            //create the task
            //submit the task.
            //store the response in a Future<Integer>
            //add to the list of futures.
            futureList.add(es.submit(new PowerOfTwo(num)));
            //Here, Client got an acknowledgement that task is in progress
            //once it's completed , we can fetch it from the Future<Integer> box.
            //Now, Client /Main thread can carry on with other tasks.
            //Hence, it's a Asynchronous Flow.
        }
        //Now, Client's only task is to get all the results.
        for(Future<Integer> future : futureList){
            try {
                //Now, this is a Blocking Call and not asynchronous Flow anymore!
                //Client/Main thread have to wait for execution to finish.
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        es.shutdown();
    }
}
