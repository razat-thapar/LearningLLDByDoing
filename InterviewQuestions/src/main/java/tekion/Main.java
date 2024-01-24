package tekion;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        //  Find pairs which add up to a number in an array.
        // if input integer array is {2, 5, 6, 3, 9, 7, 11} and given sum is 9, output should be {6,3} and {2,7}
        int[] arr = {1,1,2, 2, 5, 5, 9, 7, 11};
        int sum = 11;
        pairSumPrinter(arr,sum);
    }
    public static void pairSumPrinter(int[] arr, int sum){
        int n = arr.length;
        int freq;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++) {
            //arr[i]
            //check whether sum-arr[i] exist in hm or not.
            if(hm.containsKey(sum-arr[i])){
                freq = hm.get(sum-arr[i]);
                while(freq>0) {
                    System.out.printf("{%d,%d}%n",arr[i],sum-arr[i]);
                    freq--;
                }
            }
            //update
            if(hm.containsKey(arr[i])){
                hm.put(arr[i],1+hm.get(arr[i]));
            }else {
                hm.put(arr[i], 1);
            }
        }

    }
}

