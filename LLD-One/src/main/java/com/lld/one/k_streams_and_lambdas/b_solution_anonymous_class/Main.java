package com.lld.one.k_streams_and_lambdas.b_solution_anonymous_class;

public class Main {
    public static void main(String[] args) {
        //Scenario : Only need to write the logic inside run() method and no need to create a new class.
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("executing a new task!");
            }
        });
        t.start();
    }
}
