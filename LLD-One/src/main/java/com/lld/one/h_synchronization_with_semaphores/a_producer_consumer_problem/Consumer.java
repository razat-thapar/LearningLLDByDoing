package com.lld.one.h_synchronization_with_semaphores.a_producer_consumer_problem;

import java.util.Queue;

public class Consumer implements Runnable{
    private Queue<Item> store;
    private int capacity;
    public Consumer(Queue<Item> store, int capacity){
        this.store = store;
        this.capacity  = capacity;
    }

    @Override
    public void run() {
        if(store.size() > 0){
            //synchronization problem is occuring.
            /*
            Exception in thread "Thread-2537" java.util.NoSuchElementException
                at java.base/java.util.LinkedList.removeFirst(LinkedList.java:274)
                at java.base/java.util.LinkedList.remove(LinkedList.java:689)
                at com.lld.one.h_synchronization_with_semaphores.a_producer_consumer_problem.Consumer.run(Consumer.java:16)
                at java.base/java.lang.Thread.run(Thread.java:833)
             */
            //tc1 is preempted here.
            //tc2 is resumed and removes the item and exit.
            //tc1 is resumed and tries to remove and get exception that queue is empty;
            System.out.printf("store size before removing : [%d] Consumer %s %n",store.size(),Thread.currentThread().getName());
            Item removedItem = store.remove();
            //System.out.printf("[%d]/[%d] Consumer %s consumed : %s%n",store.size(),capacity,Thread.currentThread().getName(),removedItem);
            System.out.printf("store size after removing : [%d] Consumer %s %n",store.size(),Thread.currentThread().getName());
        }
    }
}
