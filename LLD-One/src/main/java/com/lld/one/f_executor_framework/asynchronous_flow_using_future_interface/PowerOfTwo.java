package com.lld.one.f_executor_framework.asynchronous_flow_using_future_interface;

import java.util.concurrent.Callable;

public class PowerOfTwo implements Callable<Integer> {
    Integer num ;
    public PowerOfTwo(Integer num){
        this.num = num;
    }
    @Override
    public Integer call() throws Exception {
        System.out.printf("%s is working on pow(2,%d) %n",Thread.currentThread().getName(),num);
        return 1<<num;
    }
}
