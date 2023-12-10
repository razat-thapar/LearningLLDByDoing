package com.lld.one.f_executor_framework.merge_sort_using_multithreading.runnables;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static java.lang.Thread.sleep;

public class MergeSort implements Runnable {
    private int[] arr;
    private int s;
    private int e;
    private ExecutorService es;
    public MergeSort(int[] arr, int s, int e, ExecutorService es){
        this.arr=arr;
        this.s=s;
        this.e=e;
        this.es=es;
    }

    @Override
    public void run() {
        //assumption: given an array arr[s,e] , do merge sort.
        //base case.
        if(s>=e){
            //System.out.printf("[ %d , %d ] task completed %n",s,e);
            return;
        }
        //get mid.
        int mid = (s+e)/2;
        Future f1 = es.submit(new MergeSort(arr,s,mid,es));
        Future f2 = es.submit(new MergeSort(arr,mid+1,e,es));

        //wait while f1 and f2 tasks are finished.
        try {
            f1.get();
            f2.get();
        } catch (InterruptedException | ExecutionException ex) {
            throw new RuntimeException(ex);
        }
//        while(!f1.isDone() && !f2.isDone()){
//            System.out.printf("[ %d , %d ] task in progress %n",s,e);
//        }

        //merge two sorted arrays
        int p1= s , p2=mid+1 ,k=0;
        int[] temp = new int[e-s+1];
        while(p1<=mid && p2<=e){
            if(arr[p1]<= arr[p2]){
                temp[k]=arr[p1];
                k++;
                p1++;
            }else{
                temp[k]=arr[p2];
                k++;
                p2++;
            }
        }
        while(p1<=mid){
            temp[k]=arr[p1];
            k++;
            p1++;
        }
        while(p2<=e){
            temp[k]=arr[p2];
            k++;
            p2++;
        }
        //copy
        k=0;
        for(int i=s;i<=e;i++){
            arr[i]=temp[k];
            k++;
        }
        //System.out.printf("[ %d , %d ] task completed %n",s,e);
    }
}
