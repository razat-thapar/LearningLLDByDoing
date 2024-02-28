package com.lld.one.h_synchronization_with_semaphores.c_fix2_semaphores;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public abstract class Base implements Runnable{
    protected Queue<Item> store;
    protected Semaphore sp ;
    protected Semaphore sc ;
    public Base(Queue<Item> store , Semaphore sp , Semaphore sc){
        this.store = store;
        this.sc = sc;
        this.sp = sp;
    }
}
