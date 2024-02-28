package com.lld.one.g_synchronization.b_fix_using_object_level_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Scenario 1:
        int iterations = 100000;
        Lock lock = new ReentrantLock();
        Counter counter = new Counter();
        Adder adder = new Adder(counter,iterations,lock);
        Subtractor subtractor = new Subtractor(counter,iterations,lock);
        //execute both the tasks concurrently.
        Thread t1 = new Thread(adder);
        Thread t2 = new Thread(subtractor);
        t1.start();
        t2.start();
        //main thread should wait for t1 and t2 to finish.
        t1.join();
        t2.join();
        System.out.printf("The value of Counter is : %d",counter.i);
    }
}
