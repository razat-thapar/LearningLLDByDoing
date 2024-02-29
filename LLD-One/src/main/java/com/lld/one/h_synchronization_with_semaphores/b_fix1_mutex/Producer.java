package com.lld.one.h_synchronization_with_semaphores.b_fix1_mutex;

import java.util.Queue;

public class Producer implements Runnable{
    private Queue<Item> store;
    private int capacity;
    public Producer(Queue<Item> store, int capacity){
        this.store = store;
        this.capacity = capacity;
    }
    @Override
    public void run(){
        Item newItem = new Item("Shirt");
        synchronized (store) {
            if (store.size() < capacity) {
                //System.out.printf("store size before adding : [%d] Producer %s %n", store.size(), Thread.currentThread().getName());
                store.add(newItem);
                //System.out.printf("[%d]/[%d] Producer %s produced : %s%n",store.size(),capacity,Thread.currentThread().getName(),newItem);
                System.out.printf("store size after adding : [%d] Producer %s %n", store.size(), Thread.currentThread().getName());
            }
        }
    }
}
