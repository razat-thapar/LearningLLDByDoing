package com.lld.two.b_singleton_pattern.f_eager_initilization;

import java.util.concurrent.Callable;

public class CreateObject implements Callable<SingletonClass> {
    private int i ;
    public CreateObject(int i){
        this.i = i;
    }

    @Override
    public SingletonClass call() throws Exception {
        System.out.printf("Task : %d executed by %s%n",i,Thread.currentThread().getName());
        return SingletonClass.getObject();
    }
}
