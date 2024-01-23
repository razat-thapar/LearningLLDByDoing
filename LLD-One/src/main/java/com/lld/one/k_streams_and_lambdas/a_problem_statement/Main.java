package com.lld.one.k_streams_and_lambdas.a_problem_statement;

public class Main {
    public static void main(String[] args) {
        //Problem statement: Create an object of an Interface.

        //Scenario 1: creating a new thread using a new Runnable class.
        Thread t  = new Thread(new Task());
        t.start();
    }
}
