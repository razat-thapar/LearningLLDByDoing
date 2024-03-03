package com.lld.one.h_deciding_no_of_threads;

public class CpuIntensiveTask extends Task {
    @Override
    public void run() {
        System.out.println("CPU intensive Task running!");
    }
}
