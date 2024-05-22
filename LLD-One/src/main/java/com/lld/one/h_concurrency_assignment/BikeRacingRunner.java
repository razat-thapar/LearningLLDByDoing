package com.lld.one.h_concurrency_assignment;

import com.lld.one.h_concurrency_waiting_for_threads.a_count_down_latch.CountDownLatchDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class BikeRacingRunner {
    public static void main(String[] args) throws InterruptedException {
        Integer distance = 10;
        Integer bikersCount = 10;
        Integer countDown = 10;
        CountDownLatch countDownLatch = new CountDownLatch(bikersCount);
        //Create bikers.
        List<Biker> bikerList = new ArrayList<Biker>();
        bikerList.add(new Biker("A",countDownLatch,distance));
        bikerList.add(new Biker("B",countDownLatch,distance));
        bikerList.add(new Biker("C",countDownLatch,distance));
        bikerList.add(new Biker("D",countDownLatch,distance));
        bikerList.add(new Biker("E",countDownLatch,distance));
        bikerList.add(new Biker("F",countDownLatch,distance));
        bikerList.add(new Biker("G",countDownLatch,distance));
        bikerList.add(new Biker("H",countDownLatch,distance));
        bikerList.add(new Biker("I",countDownLatch,distance));
        bikerList.add(new Biker("J",countDownLatch,distance));
        //initialize a Race.
        HostRace hostRace = new HostRace(countDownLatch,bikerList,countDown,distance);
        //start the race.
        hostRace.start();
    }

}
