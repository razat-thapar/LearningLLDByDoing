package com.lld.one.h_concurrency_leetcode_problems.b_1115_print_fooBar_alternatively;

public class Runner {
    public static void main(String[] args) {
        //Approach 1: Semaphore way
        //Approach 2: Mutex + wait() and notifyAll() + boolean flag
        int iterations = 10;
        //create a shared resource fooBar
        FooBar2 fooBar = new FooBar2(iterations);
        //create two threads
        new Thread(()-> {
            try {
                fooBar.bar();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()-> {
            try {
                fooBar.foo();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
