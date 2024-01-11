package com.lld.two.h_decorator_pattern.a_icecream_example;
import java.util.*;
class Test {
    public static void main(String[] args) {
        int[] nums = {28,5,58,91,24,91,53,9,48,85,16,70,91,91,47,91,61,4,54,61,49};
        System.out.println(countSubarrays(nums,1));
    }
    public static long countSubarrays(int[] A, int k) {
        //B.F : consider all subarrays and get max and get count and update ans.
        //TC: O(n^3) SC: O(1)
        //Idea 2: Consider all subarrays & Carry forward max and hm<int,int> info
        //TC: O(n^2) SC: O(n)
        //Idea 3: Two pointers + Maintain deque<int> indexes to get max, Maintain hm<int,int> to get count.
        //start : s=0,e=0
        //direction: if maxcount >=k then s++  , else e++
        //TC: O(N) SC: O(N)
        int s=0,e=0,n=A.length,max;
        long freq;
        long ans = 0;
        //edge cases.
        Deque<Integer> dq = new ArrayDeque<>();
        Map<Integer,Long> hm = new HashMap<>();
        //initilize.
        hm.put(A[e],1L);
        dq.addLast(e);
        //two pointers.
        while(e<n){
            //get max.
            max = A[dq.getFirst()];
            //get freq
            freq = hm.get(max);
            //check
            if(freq >= k ){
                ans += n-e;
                //remove char A[s]
                //update dequeu.
                if(dq.getFirst() == s){
                    dq.removeFirst();
                }
                //update hm.
                if(hm.get(A[s])>1){
                    hm.put(A[s],hm.get(A[s])-1);
                }else{
                    hm.remove(A[s]);
                }
                s++;
                //edge case.
                if(s>e){
                    e=s;
                    if(e==n){break;}
                    //update deque
                    while(!dq.isEmpty() && A[dq.getLast()]<A[e]){
                        dq.removeLast();
                    }
                    dq.addLast(e);
                    //update hm
                    if(hm.containsKey(A[e])){
                        hm.put(A[e],1+hm.get(A[e]));
                    }else{
                        hm.put(A[e],1L);
                    }
                }
            }else{
                //add more chars.
                e++;
                if(e==n) {
                    break;
                }
                //update deque
                while(!dq.isEmpty() && A[dq.getLast()]<A[e]){
                    dq.removeLast();
                }
                dq.addLast(e);
                //update hm
                if(hm.containsKey(A[e])){
                    hm.put(A[e],1+hm.get(A[e]));
                }else{
                    hm.put(A[e],1L);
                }
            }
        }
        return ans;
    }
}
