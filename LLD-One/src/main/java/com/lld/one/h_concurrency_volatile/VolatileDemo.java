package com.lld.one.h_concurrency_volatile;

import java.sql.SQLOutput;

public class VolatileDemo {
    public static void main(String[] args) throws InterruptedException {
        //creating a shared variable.
        SharedVariable sharedVariable = new SharedVariable();
        //creating 5 threads with same task.
        Thread thread;
        for(int i=0;i<5;i++){
            thread = new Thread(new Task(sharedVariable));
            thread.start();
        }
        Thread.sleep(1000);
        System.out.printf("%s is stopping All threads%n",Thread.currentThread().getName());
        sharedVariable.setDoPrint(false);//updating the shared variable from main thread.


    }

}
