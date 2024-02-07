package com.lld.one.h_synchronization_with_semaphores.c_fix2_semaphores;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    private Queue<Item> store;
    private Semaphore sp;
    private Semaphore sc;
    public Producer(Queue<Item> store, Semaphore sp , Semaphore sc){
        this.store = store;
        this.sp = sp;
        this.sc = sc;
    }
    @Override
    public void run(){
        Item newItem = new Item("Shirt");
        try {
            sp.acquire(); //decrease the semaphore count for producer.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("store size before adding : [%d] Producer %s %n", store.size(), Thread.currentThread().getName());
        store.add(newItem);
        //System.out.printf("[%d]/[%d] Producer %s produced : %s%n",store.size(),capacity,Thread.currentThread().getName(),newItem);
        System.out.printf("store size after adding : [%d] Producer %s %n", store.size(), Thread.currentThread().getName());
        sc.release(); //increase the semaphore count for consumer.
    }
}
