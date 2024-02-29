package com.lld.one.h_synchronization_with_semaphores.c_partial_fix2_semaphores;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Showroom {
    public static void main(String[] args) {
        //Scenario: A Queue<Item> represents our showroom having fixed capacity.
        // A producer thread produce a new item if store is not full and consumer removes an item if store is not empty.
        List<Thread> threadList = new ArrayList<>();
        Queue<Item> store = new LinkedList<>();
        int capacity = 5;
        //max capacity of store is 5 as we have only 5 semaphores in total. (5 producer + 0 consumer)
        Semaphore sp = new Semaphore(capacity); //initially 5 producers can enter.
        Semaphore sc = new Semaphore(0); //initially 0 consumers can enter.
        //create producer and consumer threads.
        for(int i=0;i<100;i++){
            //create threads.
            Thread tp = new Thread(new Producer(store , sp,sc));
            Thread tc = new Thread(new Consumer(store , sp, sc));
            //start the threads.
            tp.start();
            tc.start();
            threadList.add(tp);
            threadList.add(tc);
        }
        //main thread waits for all the threads to complete.
        threadList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println(Thread.currentThread().getName() + " ending.....");
        //Problems Observed : Synchronization problem
        // 1. Producer threads are able to add more items than max capacity i.e., 6 items in above case.
        /*
        store size before adding : [4] Producer Thread-118
        store size after adding : [5] Producer Thread-118
        store size before adding : [3] Producer Thread-120
        store size after adding : [6] Producer Thread-120
        store size before removing : [3] Consumer Thread-119
         */
        // 2. Consumer threads are trying to remove an item even if size is zero. Hence, getting exception.
        /*
        store size before adding : [4] Producer Thread-122
        store size after adding : [4] Producer Thread-122
        store size before removing : [4] Consumer Thread-81
        store size after removing : [3] Consumer Thread-81
            at java.base/java.util.LinkedList.removeFirst(LinkedList.java:274)
            at java.base/java.util.LinkedList.remove(LinkedList.java:689)
            at com.lld.one.h_synchronization_with_semaphores.a_producer_consumer_problem.Consumer.run(Consumer.java:28)
            at java.base/java.lang.Thread.run(Thread.java:833)
         */

        //FIX 1: Mutex (Allow only 1 thread to enter the critical section i.e., store.lock() and store.unlock()
        //problems : It's very slow and we are not making optimal CPU utilization using multi-threading.

        //FIX 2 : Semaphores ( allow an upperbound of threads to enter the critical section. by having multiple locks.)
        //Problem : Race conditions may occur if the shared resource is not thread safe. Queue here.

        //        Exception in thread "Thread-3" java.util.NoSuchElementException
        //        at java.base/java.util.LinkedList.removeFirst(LinkedList.java:274)
        //        at java.base/java.util.LinkedList.remove(LinkedList.java:689)
        //        at com.lld.one.h_synchronization_with_semaphores.c_fix2_semaphores.Consumer.run(Consumer.java:18)
        //        at java.base/java.lang.Thread.run(Thread.java:833)

        //Final Fix: Semaphores + Concurrent Datastructures.
    }
}
