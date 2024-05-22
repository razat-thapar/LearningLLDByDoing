package com.lld.one.h_concurrency_assignment;

import java.time.ZonedDateTime;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;

public class Biker implements Callable<Response> {
    private Consumer<Integer> work;
    private String name;
    private CountDownLatch latch;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
    private Integer distance;
    public Biker(String name, CountDownLatch latch, Integer distance) {
        //go to starting line
        System.out.printf("Biker : %s reached the starting line!!%n",name);
        this.name = name;
        this.latch = latch;
        this.distance = distance;
        this.work = (x)->{for(int i=1;i<=x;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("Biker: %s crossed %d kms%n",name,i);
        }};
    }
    @Override
    public Response call() throws Exception {
        latch.countDown();
        //intialize the start time.
        startTime = ZonedDateTime.now();
        //do work
        work.accept(distance);
        //intialize the finish time.
        endTime = ZonedDateTime.now();

        return new Response(name,startTime, endTime);
    }
}
