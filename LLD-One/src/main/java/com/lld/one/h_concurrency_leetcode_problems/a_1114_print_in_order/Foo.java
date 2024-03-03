package com.lld.one.h_concurrency_leetcode_problems.a_1114_print_in_order;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Foo {
    private Semaphore semaphoreSecond;
    private Semaphore semaphoreThird;
    public Foo(){
        this.semaphoreSecond = new Semaphore(0);
        this.semaphoreThird = new Semaphore(0);
    }
    public void printFirst(){
        System.out.print("first");
        semaphoreSecond.release();
    }
    public void printSecond() throws InterruptedException {
        semaphoreSecond.acquire();
        System.out.print("second");
        semaphoreThird.release();
    }

    public void printThird() throws InterruptedException {
        semaphoreThird.acquire();
        System.out.print("third");
    }

    public void printInOrder(List<Integer> nums){
        validate(nums);
        nums.forEach(num ->{
            if(num==1){
                //create a new thread that invokes printfirst()
                new Thread(()-> this.printFirst()).start();
            }else if(num==2){
                new Thread(() -> {
                    try {
                        this.printSecond();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }).start();
            }else{
                new Thread(() -> {
                    try {
                        this.printThird();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }).start();
            }
        });
    }

    private static void validate(List<Integer> nums) {
        //validate if nums have size = 1.
        if(nums.size()!=3 || new HashSet<>(nums).size()!=3){
            throw new RuntimeException("Please provide a valid input, should have only 1,2,3 values");
        }
    }
}
