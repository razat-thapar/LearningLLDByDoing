package com.lld.one.k_streams_and_lambdas.b_solution1_anonymous_type;

public class Main {
    public static void main(String[] args) {
        //Scenario : Only need to write the logic inside run() method and no need to create a new class.
        //Anonymous class object approach !  or Inline Class object.
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("executing a new task!");
                //class name : com.lld.one.k_streams_and_lambdas.b_solution_anonymous_class.Main$1
                // see anonymous class name is Main$1 .
                System.out.printf("class name : %s",this.getClass().getName());
            }
        });
        t.start();
    }
}
