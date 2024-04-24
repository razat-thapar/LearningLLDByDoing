package com.lld.one.h_concurrent_datastructures.b_concurrent_collections.blockingQueue;

import lombok.AllArgsConstructor;

import java.util.concurrent.BlockingQueue;
@AllArgsConstructor
public class Producer implements Runnable{
    private BlockingQueue<Payload> buffer;
    private int iterations;

    @Override
    public void run() {
        for(int i=1;i<=iterations;i++){
            try {
                Payload payload = new Payload();
                buffer.put(payload);
                System.out.printf("%s put by %s %s%n",payload,"Producer",Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
