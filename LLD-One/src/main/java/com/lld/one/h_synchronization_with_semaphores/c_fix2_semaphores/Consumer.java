package com.lld.one.h_synchronization_with_semaphores.c_fix2_semaphores;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
    private Queue<Item> store;
    private Semaphore sp ;
    private Semaphore sc ;
    public Consumer(Queue<Item> store , Semaphore sp , Semaphore sc){
        this.store = store;
        this.sc = sc;
        this.sp = sp;
    }

    @Override
    public void run() {
        try {
            sc.acquire(); //decreasing the count of consumer semaphores.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("store size before removing : [%d] Consumer %s %n", store.size(), Thread.currentThread().getName());
        Item removedItem = store.remove();
        //System.out.printf("[%d]/[%d] Consumer %s consumed : %s%n",store.size(),capacity,Thread.currentThread().getName(),removedItem);
        System.out.printf("store size after removing : [%d] Consumer %s %n", store.size(), Thread.currentThread().getName());
        sp.release(); // increase the count of producer semaphores.
    }
}
