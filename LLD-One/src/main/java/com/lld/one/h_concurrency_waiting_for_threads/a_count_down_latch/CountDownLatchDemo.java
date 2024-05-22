package com.lld.one.h_concurrency_waiting_for_threads.a_count_down_latch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(new Worker(latch)).start();
        }
        latch.await();//blocks the current thread until all workers thread are executed.
        System.out.println("All threads executed the work succesfully!");//this will be executed once all 5 threads have completed their work.

    }
    public static class Worker implements Runnable {
        private CountDownLatch latch;
        public Worker(CountDownLatch latch) {
            this.latch = latch;
        }
        @Override
        public void run() {
            //do some work.
            System.out.println(Thread.currentThread().getName()+" performed work!!");
            System.out.println(Thread.currentThread().getName()+" Counted down!!!");
            latch.countDown();
        }
    }
}
