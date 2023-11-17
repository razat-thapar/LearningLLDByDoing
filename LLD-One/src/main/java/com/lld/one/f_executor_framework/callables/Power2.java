package com.lld.one.f_executors_threadpool.callables;

import java.util.concurrent.Callable;

public class Power2 implements Callable<Double> {

    double num ;
    public Power2(double num){
        this.num=num;
    }

    @Override
    public Double call() throws Exception {
        System.out.printf("Task :%f processed by %s %n",this.num,Thread.currentThread().getName());
        return Math.pow(2.0,num);
    }
}
