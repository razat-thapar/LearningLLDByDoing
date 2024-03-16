package facebook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxLengthSubarrayWithEqualCount {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,0,1,1,0,1,0,1,0,0,0,0,1,1,1,1,1};
        //print array.
        Arrays.stream(nums).forEach(num-> System.out.print(num+","));
        System.out.printf("%nMax binary subarray with equal zeroes and one's = %d %n",findMaxLength(nums));

    }
    public static int findMaxLength(int[] nums){
        int n = nums.length,negCountOf1 = 0,ans=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            //get neg counting of 1.
            negCountOf1 = (nums[i]==1)?negCountOf1+1:negCountOf1-1;
            //case 1: it's zero
            if(negCountOf1==0){
                //[0,i] is subarray with zero negative count
                ans = Math.max(ans, i+1);
            }
            //case 2: it repeats.
            if(map.containsKey(negCountOf1)){
                //[val+1,i] is subarry with zero negative count.
                ans = Math.max(ans, i-map.get(negCountOf1));
            }else{
                //first occurence, hence, update map.
                map.put(negCountOf1,i);
            }
        }
        return ans;
    }

}
