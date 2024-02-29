package Wissen;

import java.util.concurrent.Callable;

public class Task implements Callable<Integer> {
    Integer i ;
    public Task(Integer i){
        this.i = i;
    }
    @Override
    public Integer call() throws Exception {
        return i;
    }
}
