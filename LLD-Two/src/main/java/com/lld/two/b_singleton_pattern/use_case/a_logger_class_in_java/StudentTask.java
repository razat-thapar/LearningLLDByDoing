package com.lld.two.b_singleton_pattern.use_case.a_logger_class_in_java;
import java.util.logging.Logger;
import java.util.logging.Level;

public class StudentTask implements Runnable{
    private Logger logger;
    private int i;
    public StudentTask(Logger logger, int i){
        this.logger = logger;
        this.i = i;
    }
    @Override
    public void run(){
        System.out.printf("INFO student task : %d %s%n",i,Thread.currentThread().getName());
        logger.log(Level.INFO,"task : "+i+" "+Thread.currentThread().getName());
    }

}
