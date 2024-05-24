package vlink;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TaskA implements Runnable{
    private Object a;
    private Object b;

    @Override
    public void run() {
        //acquire lock on A.
        synchronized (a) {
            System.out.printf("acquired lock on A %s%n",Thread.currentThread());
            synchronized (b) {
                System.out.printf("acquired lock on B %s%n",Thread.currentThread());
            }
        }

    }
}
