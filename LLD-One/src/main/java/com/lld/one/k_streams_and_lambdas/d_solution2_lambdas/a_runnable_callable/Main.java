package com.lld.one.k_streams_and_lambdas.d_solution2_lambdas.a_runnable_callable;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        //syntax of lambdas.
        // (parameters of functional interface method) -> { body of method. }

        //Scenario 1: creating a new thread using runnable.
        Runnable r1 = () -> {
            System.out.println("This is a new task!");
        };
        Thread t1 = new Thread(r1);
        t1.start();
        //Another way of writing it.
        Thread t2 = new Thread( () -> System.out.println("This is our 2nd Task!"));
        t2.start();

        //Scenario 2: using lambda to write implementation of Custom functional interface
        Custom cust1 = (a,b) -> {
            return a*b;
        };
        int product = cust1.doSomething(2,3);

        //Scenario 3: Creating a new Thread using callable.
        Callable<Integer> c1 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 32;
            }
        };

        //another way of writing it.
        Callable<Integer> c2 = () -> {
            return 32;
        };

        //another more compact way of writing it.
        Callable<Integer> c3 = () -> 32;

        //Scenario 4: Creating a lambda for interface with overloaded methods.
        // Conclusion : Doesn't work. Only works for functional interfaces.
//        RunnableCustom test1 = () -> {
//            System.out.println("Hello");
//        };

        //Scenario 5: Custom functional Interface with generic type.
        MathsOperations<Integer> add = (a,b) -> {return a+b;};
        MathsOperations<Double> divide = (a,b) -> a/b;
        System.out.println();

    }
}
