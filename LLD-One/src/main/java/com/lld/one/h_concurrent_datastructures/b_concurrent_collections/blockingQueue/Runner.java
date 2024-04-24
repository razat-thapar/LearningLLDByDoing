package com.lld.one.h_concurrent_datastructures.b_concurrent_collections.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Runner {
    public static void main(String[] args) {
        //demonstrating solution to Producer and Consumer problem using BlockingQueue<E> interface.
        int capacity = 2;
        BlockingQueue<Payload> buffer = new ArrayBlockingQueue<>(capacity);
        int producerThreads = 1;
        int consumerThreads = 1;
        int iterations = 4;
        for(int i=0;i<producerThreads;i++){
            new Thread(new Producer(buffer,iterations)).start();
        }
        for(int i=0;i<consumerThreads;i++){
            new Thread(new Consumer(buffer,iterations)).start();
        }
    }
}
