package com.lld.two.b_singleton_pattern.use_case.b_custom_logger;

import java.util.concurrent.TimeUnit;

public class LogMessage implements Runnable{
    private String message;
    private Logger logger;
    private String fullFilePath;
    private LogLevel level;
    public LogMessage(String message, String fullFilePath, LogLevel level){
        this.message = message;
        this.fullFilePath = fullFilePath;
        this.level = level;
    }
    @Override
    public void run(){
        logger = SingletonLogger.getInstance();
        logger.setLogFile(fullFilePath);
        logger.log(level,message);
        logger.flush();
        System.out.printf("%s is written successfully by %s%n",message,Thread.currentThread().getName());
    }
}
