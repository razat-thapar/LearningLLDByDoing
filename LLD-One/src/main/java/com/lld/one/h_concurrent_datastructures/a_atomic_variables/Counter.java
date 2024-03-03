package com.lld.one.h_concurrent_datastructures.a_atomic_variables;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    AtomicInteger i;
    public Counter(){
        this.i= new AtomicInteger(0);
    }
}
