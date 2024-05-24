package com.lld.one.h_concurrency_volatile;


public class Task implements Runnable{
    private SharedVariable sharedVariable;
    public Task(SharedVariable sharedVariable) {
        this.sharedVariable = sharedVariable;
    }
    @Override
    public void run() {
        while(sharedVariable.isDoPrint()){
            System.out.printf("%s is Running %n",Thread.currentThread().getName());
        }
    }
}
