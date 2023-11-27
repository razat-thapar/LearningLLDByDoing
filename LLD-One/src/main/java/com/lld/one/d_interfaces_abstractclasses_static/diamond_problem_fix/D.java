package com.lld.one.d_interfaces_abstractclasses_static.diamond_problem_fix;

public class D implements B,C{
    //interface makes multiple inheritance possible.
    @Override
    public void fun() {
        System.out.println("This is fun method!");
    }

    @Override
    public void run() {
        System.out.println("This is run method!");
    }
}
