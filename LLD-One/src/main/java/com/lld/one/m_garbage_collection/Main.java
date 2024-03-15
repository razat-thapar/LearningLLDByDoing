package com.lld.one.m_garbage_collection;

public class Main {
    public static void main(String[] args) {
        //create objects
        int iterations = 20;
        GCDemo gcDemo = new GCDemo(1);
        //unreference it.
        gcDemo = null;
        System.out.println("GCDemo 1 is unreferenced by Main thread! ");
        System.gc();
        System.out.println("GC is called explicitly! by Main thread!");
        for(int i=0;i<iterations;i++){
            System.out.println("Main thread is running !");
        }

    }
}
