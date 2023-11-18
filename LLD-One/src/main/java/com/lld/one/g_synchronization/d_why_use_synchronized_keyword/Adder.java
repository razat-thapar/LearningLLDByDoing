package com.lld.one.g_synchronization.d_why_use_synchronized_keyword;

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
            System.out.printf("Adder Iteration : %d %n",i);
            counter.incrementValue();
        }
    }
}
