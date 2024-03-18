package com.lld.two.b_singleton_pattern.g_double_check_locking_serialization_fix;

import java.util.concurrent.Callable;

public class CreateObject implements Callable<SerializedSingletonClass> {
    private int i ;
    public CreateObject(int i){
        this.i = i;
    }

    @Override
    public SerializedSingletonClass call() throws Exception {
        System.out.printf("Task : %d executed by %s%n",i,Thread.currentThread().getName());
        return SerializedSingletonClass.getObject();
    }
}
