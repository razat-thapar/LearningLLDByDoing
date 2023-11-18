package com.lld.one.g_synchronization.b_fix_using_lock;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable{
    private int iterations;
    private Counter counter;
    private Lock lock;
    public Adder(Counter counter, int iterations,Lock lock){
        this.counter=counter;
        this.iterations=iterations;
        this.lock=lock;
    }

    @Override
    public void run() {
        for(int i=1;i<=iterations;i++){
            System.out.printf("Adder Iteration : %d %n",i);
            lock.lock();
            System.out.printf("Inside Adder lock, counter.i : %d %n",this.counter.i);
            this.counter.i++;
            lock.unlock();
        }
    }
}
