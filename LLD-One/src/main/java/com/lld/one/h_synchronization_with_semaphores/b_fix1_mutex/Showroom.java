package com.lld.one.h_synchronization_with_semaphores.b_fix1_mutex;

import java.time.Instant;
import java.util.LinkedList;
import java.util.Queue;

public class Showroom {
    public static void main(String[] args) {
        //Scenario: A Queue<Item> represents our showroom having fixed capacity.
        // A producer thread produce a new item if store is not full and consumer removes an item if store is not empty.

        Queue<Item> store = new LinkedList<>();
        //max capacity of store.
        int capacity = 5;
        //create producer and consumer threads.
        for(int i=0;i<100;i++){
            //create threads.
            Thread tp = new Thread(new Producer(store,capacity));
            Thread tc = new Thread(new Consumer(store,capacity));
            //start the threads.
            tp.start();
            tc.start();
        }
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

    }
}
