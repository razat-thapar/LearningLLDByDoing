package com.lld.one.h_concurrency_waiting_for_threads.b_circular_barrier;

import java.util.concurrent.CyclicBarrier;

public class CircularBarrierDemo {
    public static void main(String[] args) {

    }
    public static class Worker implements Runnable {
        private CyclicBarrier cyclicBarrier ;
        public Worker(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }
        @Override
        public void run() {
            //do some work.
            System.out.println(Thread.currentThread().getName()+" performed work!!");
        }
    }
}
