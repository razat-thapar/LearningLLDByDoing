package com.lld.one.h_deciding_no_of_threads;

public class InputOutputIntensiveTask extends Task{
    @Override
    public void run() {
        System.out.println("IO Intensive Task running...");
    }
}
