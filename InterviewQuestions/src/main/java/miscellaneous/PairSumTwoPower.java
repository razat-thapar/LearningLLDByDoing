package miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class PairSumTwoPower {
    public static void main(String[] args) {
        //given array, Input: arr[] = {3, 11, 14, 5, 13}
        //Output: 2
        //Given an array arr[] of positive integers, the task is to count the maximum possible number of pairs (arr[i], arr[j]) such that arr[i] + arr[j] is a power of 2.
        //Assumption: i!=j
        int[] arr = {3, 11, 14, 5, 13};
        int count = getPairSumTwoPower(arr);
    }

    private static int getPairSumTwoPower(int[] arr) {
        int count = 0 , n=arr.length, diff;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=n-1;i>=0;i--){
            //arr[i] current element.
            //check if diff = (1<<i)-arr[i] is present in hm or not.
            for(int j=0;j<32;j++){
                diff = (1<<j)-arr[i];
                if(map.containsKey(diff)){
                    count += map.get(diff);
                    System.out.printf("{%d,%d} ",diff,arr[i]);
                }
            }
            //update map.
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }
        return count;
    }
}
