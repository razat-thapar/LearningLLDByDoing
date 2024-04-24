package com.lld.one.h_concurrent_datastructures.b_concurrent_collections.blockingQueue;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;
public class Payload {
    private static AtomicInteger id = new AtomicInteger(0);
    public Payload(){
        id.getAndIncrement();
    }
    @Override
    public String toString(){
        return ("Payload "+ id.get());
    }
}
