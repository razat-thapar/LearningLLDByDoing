package com.lld.two.b_singleton_pattern.use_case.b_custom_logger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        //objective: Write some INFO level messages in the following path D:\My Preparation\ScalerAcademy\LLD\LearningLLDByDoing
        // in a log.txt file using custom Logger implementation.
        String filePath = "D:\\My Preparation\\ScalerAcademy\\LLD\\LearningLLDByDoing\\LLD-Two";
        String filename = "log.txt";
        String fullFilePath = filePath+"\\"+filename;

        ExecutorService es = Executors.newFixedThreadPool(5);
        //write 100 log messages using 10 threads.
        for(int i=0;i<100000;i++){
            es.submit(new LogMessage("message "+i,fullFilePath,LogLevel.INFO));
        }
        es.shutdown();
    }
}
