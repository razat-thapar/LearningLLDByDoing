package com.lld.one.f_executor_framework.merge_sort_using_multithreading.callables;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MergeSort implements Callable<int[]> {
    private int[] arr;
    private int s, e;
    private ExecutorService es;
    public MergeSort(int[] arr, int s, int e, ExecutorService es){
        this.arr=arr;
        this.s=s;
        this.e=e;
        this.es = es;
    }
    @Override
    public int[] call() throws Exception {
        //assumption: given an array arr[s,e] , do merge sort and return new sorted array.
        //base case.
        if(s==e){
            int[] temp = new int[1];
            temp[0]=arr[s];
            return temp;
        }
        if(s>e){
            int[] temp = new int[0];
            return temp;
        }
        //get mid.
        int mid = (s+e)/2;
        Future<int[]> sorted1 = es.submit(new MergeSort(arr,s,mid,es));
        Future<int[]> sorted2 = es.submit(new MergeSort(arr,mid+1,e,es));
        int[] temp1 = sorted1.get();
        int[] temp2 = sorted2.get();
        //merge two sorted arrays.
        int p1= 0 , p2=0 ,k=0;
        int[] temp = new int[e-s+1];
        while(p1<temp1.length && p2<temp2.length){
            if(temp1[p1]<= temp2[p2]){
                temp[k]=temp1[p1];
                k++;
                p1++;
            }else{
                temp[k]=temp2[p2];
                k++;
                p2++;
            }
        }
        while(p1<temp1.length){
            temp[k]=temp1[p1];
            k++;
            p1++;
        }
        while(p2<temp2.length) {
            temp[k] = temp2[p2];
            k++;
            p2++;
        }
        return temp;
    }
}
