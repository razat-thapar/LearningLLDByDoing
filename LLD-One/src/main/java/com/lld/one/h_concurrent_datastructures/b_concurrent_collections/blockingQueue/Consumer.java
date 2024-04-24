package com.lld.one.h_concurrent_datastructures.b_concurrent_collections.blockingQueue;

import lombok.AllArgsConstructor;

import java.util.concurrent.BlockingQueue;
@AllArgsConstructor
public class Consumer implements Runnable{
    private BlockingQueue<Payload> buffer;
    private int iterations;
    @Override
    public void run() {
        for(int i=1;i<=iterations;i++){
            try {
                System.out.printf("%s taken by %s %s%n",buffer.take(),"Consumer",Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
