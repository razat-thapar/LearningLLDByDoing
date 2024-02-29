package com.lld.one.h_synchronization_with_semaphores.d_bestfix2_semaphores_concurrent_datastructures;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public abstract class Base implements Runnable{
    protected ConcurrentLinkedQueue<Item> store;
    protected Semaphore sp ;
    protected Semaphore sc ;
    public Base(ConcurrentLinkedQueue<Item> store , Semaphore sp , Semaphore sc){
        this.store = store;
        this.sc = sc;
        this.sp = sp;
    }
}
