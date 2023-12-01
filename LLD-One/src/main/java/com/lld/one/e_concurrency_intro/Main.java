package com.lld.one.e_concurrency_intro;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Inside thread : %s %n", Thread.currentThread().getName());
        //create a new thread to print 1 to 10 number
        for(int i=1;i<=10;i++){
            System.out.printf("Thread : %s, created printer i:  %d %n",Thread.currentThread().getName(),i);
            Thread t = new Thread(new NumberPrinter(i));
            t.start();
        }
        System.out.printf("Exiting thread : %s %n", Thread.currentThread().getName());

    }
}
