package com.lld.one.e_concurrency_intro;

public class NumberPrinter implements Runnable{
    int i;
    public NumberPrinter(int i){
        this.i=i;
    }
    @Override
    public void run(){
        System.out.printf("Thread : %s , The number is : %d %n",Thread.currentThread().getName(),this.i);
    }
}
