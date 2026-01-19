package miscellaneous;

import java.util.Arrays;
import java.util.Random;

public class RandomizedQuickSort{
    public static void main(String[] args) {
        int[] A = {5,3,1,8,11,6,10,18,0,-1,11,32,32,23};
        quickSort(A,0,A.length-1);
        Arrays.stream(A).forEach(System.out::println);
    }
    public static void quickSort(int[] A, int s, int e){
        //assumption: given a subarray A[s:e] , do sort the subarray in ascending order.
        //base case.
        if(s>=e){
            return;
        }
        //rearrange
        int idx = rearrange(A,s,e);
        quickSort(A,s,idx-1);
        quickSort(A,idx+1,e);
    }
    public static int rearrange(int[] A, int s, int e){
        Random random = new Random();
        int pivot = s;
        int r = s+ random.nextInt(e-s+1); //random index.
        //swap pivot index with random index so that it becomes our pivot.
        swap(A,r,pivot);
        int p1 = pivot+1;
        int p2 = e;
        while(p1<=p2){
            if(A[p1]<=A[pivot]){
                p1++;
            }else if(A[p2]>A[pivot]){
                p2--;
            }else{
                //both are unhappy.
                swap(A,p1,p2);
                p1++;
                p2--;
            }
        }
        swap(A,pivot,p2);
        return p2;
    }
    public static void swap(int[] A, int p1 , int p2){
        int temp = A[p1];
        A[p1] = A[p2];
        A[p2] = temp;
    }
}
