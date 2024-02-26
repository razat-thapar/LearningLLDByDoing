package com.lld.one.f_executor_framework.asynchronous_flow_using_future_interface;

public class PowerOfTwoRunnable implements Runnable {
    private Integer num;
    private Integer result;
    public PowerOfTwoRunnable(Integer num){
        this.num = num;
    }
    public void run() {
        System.out.printf("%s is working on pow(2,%d) %n",Thread.currentThread().getName(),num);
        result = 1<<num;
    }
    public Integer getResult(){
        return result;
    }
}
