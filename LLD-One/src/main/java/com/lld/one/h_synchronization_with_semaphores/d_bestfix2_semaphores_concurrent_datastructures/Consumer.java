package com.lld.one.h_synchronization_with_semaphores.d_bestfix2_semaphores_concurrent_datastructures;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class Consumer extends Base {
    public Consumer(Queue<Item> store , Semaphore sp , Semaphore sc){
        super(store,sp,sc);
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
        sp.release(); // increase the count of producer semaphores.
    }
}
