package vlink;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TaskB implements Runnable{
    private Object a;
    private Object b;

    @Override
    public void run() {
        //acquire lock on B
        synchronized (b) {
            System.out.printf("acquired lock on B %s%n",Thread.currentThread());
            synchronized (a) {
                System.out.printf("acquired lock on A %s%n",Thread.currentThread());
            }
        }
    }
}
