package com.lld.one.h_concurrency_leetcode_problems.b_1115_print_fooBar_alternatively;

public class FooBar2 {
    private int iterations ;
    private boolean isFooTurn;

    public FooBar2(int iterations){
        this.iterations = iterations;
        isFooTurn = true;
    }

    public synchronized void foo() throws InterruptedException {
        for(int iteration=0;iteration<iterations;iteration++){
            if(isFooTurn==false){
                wait(); // current thread needs to wait for the current object until timeout/ notify call & current owner of lock releases it as well.
            }
            System.out.print("foo");
            isFooTurn = false; //toggle.
            notifyAll(); // notifies all threads waiting on current object to acquire lock and do their business.
        }
    }
    public synchronized void bar() throws InterruptedException {
        for(int iteration=0;iteration<iterations;iteration++){
            if(isFooTurn==true){
                wait();
            }
            System.out.print("bar");
            isFooTurn = true; //toggle.
            notifyAll();
        }
    }

}
