package com.lld.one.h_concurrent_locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        //demonstrating incrementing count variable concurrently and handling synchronization problem using Mutex.
        //creating 5 threads
        new MyThread(lock,"A");
        new MyThread(lock,"B");
        new MyThread(lock,"C");
        new MyThread(lock,"D");
        new MyThread(lock,"E");

    }
    public static class Shared{
        private static int count = 0;
    }
    public static class MyThread implements Runnable {
        private Lock lock;
        private String name;
        public MyThread(Lock lock, String name) {
            this.lock = lock;
            this.name = name;
            new Thread(this).start();
        }
        @Override
        public void run() {
            try{
                System.out.println("Starting " + name + " Thread");
                System.out.println(name + " is waiting to lock the count variable!!");
                lock.lock();
                System.out.println(name + " have acquired the lock on count variable!!");
                Shared.count++;
                System.out.println(name + " : count " + Shared.count);
                System.out.println(name + " is releasing the lock!!");
            }catch(Exception e){
                System.out.println(e);
            }finally{
                lock.unlock();
                System.out.println(name + " successfully unlocked the lock on the count variable!!");
            }

        }
    }
}
