package com.lld.one.h_concurrent_datastructures.a_atomic_variables;

public class Subtractor implements Runnable{
    private int iterations;
    private Counter counter;
    public Subtractor(Counter counter, int iterations){
        this.counter  = counter;
        this.iterations=iterations;
    }
    @Override
    public void run() {
        for(int i=1;i<=iterations;i++) {
            this.counter.i.getAndDecrement();
        }
    }
}
