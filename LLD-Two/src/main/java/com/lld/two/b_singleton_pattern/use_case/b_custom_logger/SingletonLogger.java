package com.lld.two.b_singleton_pattern.use_case.b_custom_logger;
import java.util.Date;
import java.time.Instant;
import java.io.FileWriter;
import java.io.IOException;
public class SingletonLogger implements Logger{
    //Part1 : Implement Singleton dp for Logger.
    private static SingletonLogger instance = null;
    private String logFilePath;
    private FileWriter fileWriter ;
    private boolean isClosed;
    private SingletonLogger(){
        this.isClosed = false;
    }

    @Override
    public void log(LogLevel level, String message){
        if(fileWriter == null){
            throw new IllegalStateException("logger is not initialized with setLogFile() method");
        }else if(isClosed){
            throw new IllegalStateException("file is closed!");
        }else{
            StringBuffer logMessage = new StringBuffer();
            logMessage.append(" [ ");
            logMessage.append(level);
            logMessage.append(" ] ");
            logMessage.append(Date.from(Instant.now()));
            logMessage.append(" : ");
            logMessage.append(message);
            logMessage.append(" \n ");
            try{
                fileWriter.write(logMessage.toString(),0,logMessage.length());
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void setLogFile(String filePath) {
        this.logFilePath = filePath;
        //initializing FileWriter.
        if(logFilePath != null){
            try{
                this.fileWriter = new FileWriter(logFilePath,true);
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public String getLogFile() {
        return logFilePath;
    }

    @Override
    public void flush() {
        if(fileWriter != null){
            try{
                fileWriter.flush();
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void close() {
        if(fileWriter != null){
            try{
                isClosed = true;
                fileWriter.close();
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Logger getInstance(){
        if(instance == null){
            synchronized(SingletonLogger.class){
                if(instance == null){
                    instance = new SingletonLogger();
                    return instance;
                }
            }
        }
        return instance;
    }

    public static void resetInstance(){
        instance = null ;
    }
}
