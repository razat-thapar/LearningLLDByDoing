package com.lld.one.h_synchronization_with_semaphores.d_bestfix2_semaphores_concurrent_datastructures;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class Producer extends Base {
    public Producer(Queue<Item> store, Semaphore sp , Semaphore sc){
        super(store,sp,sc);
    }
    @Override
    public void run(){
        Item newItem = new Item("Shirt");
        try {
            sp.acquire(); //decrease the semaphore count for producer.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        store.add(newItem);
        System.out.printf("store size after adding : [%d] Producer %s %n", store.size(), Thread.currentThread().getName());
        sc.release(); //increase the semaphore count for consumer.
    }
}
