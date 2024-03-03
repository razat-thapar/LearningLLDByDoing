package com.lld.one.h_concurrency_leetcode_problems.b_1115_print_fooBar_alternatively;

import java.util.concurrent.Semaphore;

public class FooBar {
    private int iterations ;
    private Semaphore fooSemaphore;
    private Semaphore barSemaphore;

    public FooBar(int iterations){
        this.iterations = iterations;
        this.fooSemaphore = new Semaphore(1);
        this.barSemaphore = new Semaphore(0);
    }

    public void foo() throws InterruptedException {
        for(int iteration=0;iteration<iterations;iteration++){
            fooSemaphore.acquire();
            System.out.print("foo");
            barSemaphore.release();
        }
    }
    public void bar() throws InterruptedException {
        for(int iteration=0;iteration<iterations;iteration++){
            barSemaphore.acquire();
            System.out.print("bar");
            fooSemaphore.release();
        }
    }

}
