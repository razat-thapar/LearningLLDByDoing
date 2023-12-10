package com.lld.one.k_streams_and_lambdas.a_problem;

public class Main {
    public static void main(String[] args) {
        //Scenario 1: creating a new thread using a new Runnable class.
        Thread t  = new Thread(new Task());
        t.start();
    }
}
