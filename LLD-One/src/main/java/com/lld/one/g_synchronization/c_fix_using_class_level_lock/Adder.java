package com.lld.one.g_synchronization.c_fix_using_class_level_lock;

public class Adder implements Runnable{
    private int iterations;
    private Counter counter;
    public Adder(Counter counter, int iterations){
        this.counter=counter;
        this.iterations=iterations;
    }

    @Override
    public void run() {
        for(int i=1;i<=iterations;i++){
            //class level locking on Counter.
            //here, only 1 thread will be able to acquire lock on any 1 instance of Counter class.
            //so, if we have multiple Counter objects, we won't be able to run Adder,Subtractor threads parallely.
            synchronized(Counter.class){
                this.counter.i++;
            }
        }
    }
}
