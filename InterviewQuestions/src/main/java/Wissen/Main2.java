package Wissen;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main2 {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        List<Future<Integer>> list = new ArrayList<>();
        for(int i=1;i<=10;i++){
            list.add(es.submit(new Task(i)));
        }
        Thread t1 = new Thread();

        //print them
        list.forEach(futureNum -> {
            try {
                System.out.println(futureNum.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        es.shutdown();
    }
}
