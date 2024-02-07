package com.lld.one.g_synchronization.c_best_fix_using_synchronized_keyword;

public class Subtractor implements Runnable{
    private final int iterations;
    private final Counter counter;

    public Subtractor(Counter counter, int iterations){
        this.counter  = counter;
        this.iterations=iterations;
    }
    @Override
    public void run() {
        for(int i=1;i<=iterations;i++) {
            System.out.printf("Subtractor Iteration : %d %n",i);
            synchronized (this.counter) {
                System.out.printf("Inside Subtractor lock, counter.i : %d %n", this.counter.i);
                this.counter.i--;
            }
        }
    }
}
