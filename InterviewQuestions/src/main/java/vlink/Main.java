package vlink;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //write a deadlock program.
        //two threads.
        //cyclic dependency. ( A , B)
        Object a = new Object();
        Object b = new Object();
        Thread t1 = new Thread(new TaskA(a,b));
        Thread t2 = new Thread(new TaskB(a,b));
        t1.start();
        t2.start();
        System.out.println("Deadlock starts");
        t1.join();
        t2.join();
        System.out.println("deadlock ends.");

    }

}
