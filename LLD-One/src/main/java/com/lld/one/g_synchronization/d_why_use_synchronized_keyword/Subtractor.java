package com.lld.one.g_synchronization.d_why_use_synchronized_keyword;

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
            System.out.printf("Subtractor Iteration : %d %n",i);
            counter.decrementValue();
        }
    }
}
