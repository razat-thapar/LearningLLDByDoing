package com.lld.two.b_singleton_pattern.use_case.a_logger_class_in_java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for(int i=1;i<=100;i++){
            //Logger follows singleton design pattern and works in multi-threaded environment.
            //Moreover, it's Thread safe while publishing messages to the output stream.
            //i.e., only one thread will be writing to output file at a time.
            es.submit( new StudentTask(Logger.getLogger("studentLogger"),i));
            es.submit( new ClassTask(Logger.getLogger("classLogger"),i));
        }
        es.shutdown();
    }
}
