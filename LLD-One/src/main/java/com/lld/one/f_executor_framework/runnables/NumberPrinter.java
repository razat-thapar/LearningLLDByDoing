package com.lld.one.f_executor_framework.runnables;

public class NumberPrinter implements Runnable{
    private int num;
    public NumberPrinter(int num){
        this.num= num;
    }
    @Override
    public void run() {
        System.out.printf("number is : %d printed by : %s%n",this.num,Thread.currentThread().getName());
    }
}
