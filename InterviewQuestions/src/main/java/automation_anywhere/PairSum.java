package automation_anywhere;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PairSum {
    public static void main(String[] args) {
        int[] input = {12,2,12,8,9,5,11,6,12,0,7,1};
        printPairWithGivenSum(input,20);
    }
    private static void printPairWithGivenSum(int[] input, int k){
        Map<Integer,Integer> map = new HashMap<>();
        //populate.
        for(int num : input){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        Set<Integer> isKeyVisited = new HashSet<>();
        for(int key: map.keySet()){
            if(isKeyVisited.contains(key)){
                continue;
            }
            //mark key visited.
            isKeyVisited.add(key);
            if(map.containsKey(k-key)){
                int pairFreq = Math.min(map.get(key),map.get(k-key));
                while(pairFreq>0){
                    System.out.printf("{%d,%d}%n",key,k-key);
                    pairFreq--;
                }
                //mark visited.
                isKeyVisited.add(k-key);
            }
        }
    }
}
