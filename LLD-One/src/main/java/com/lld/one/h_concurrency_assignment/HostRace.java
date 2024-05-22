package com.lld.one.h_concurrency_assignment;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.ArrayList;

@Getter
@AllArgsConstructor
public class HostRace {
    private CountDownLatch latch;
    private List<Biker> bikers;
    private Integer countDown;
    private Integer distance;
    public void start() throws InterruptedException {
        //logic to start the race
        //wait for all the racers to reach the starting line.
        System.out.println("Welcome to the Bike Racing Competition");
        //creating the biker threads.
        ExecutorService es = Executors.newFixedThreadPool(bikers.size());
        List<Future<Response>> futures = new ArrayList<>();
        for (Biker biker : bikers) {
            //asking them to reach to finish line.
            futures.add(es.submit(biker));
        }
        System.out.println("Starting the race in : ");
        for(int i=countDown;i>=0;i--){
            System.out.println(i);
        }
        //latch.countDown();
        //start the race.
        latch.await();
        //get the results.
        List<Response> responses = new ArrayList<>();
        futures.forEach((future)-> {
            try {
                responses.add(future.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        //calculate the rank by custom sorting based on duration.
        Collections.sort(responses,(a,b)->a.getDuration().compareTo(b.getDuration()));
        System.out.println("##################RESULTS##################################");
        //printing the ranking.
        for(int rank=1;rank<=responses.size();rank++) {
            System.out.printf("Rank : %d %s%n", rank, responses.get(rank-1));
        }

        //exit
        es.shutdown();
    }
}
