package com.lld.one.g_synchronization.d_why_use_synchronized_keyword;

public class Counter {
    private long i;
    public Counter(){
        this.i=0;
    }
    public synchronized void incrementValue(){
        this.i += 1;
    }
    public synchronized void decrementValue(){
        this.i -= 1;
    }
    public long getCount(){
        return this.i;
    }
}
