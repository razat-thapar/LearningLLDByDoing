package Accolite;

public class Main1 {
    public static void main(String[] args) {
        //array { 1,2,-4,5 , -6,7,8,9 }
        //Find the Max SubArray Sum ?
        //B>F Maintain max
        //for(int s=0;s<n;s++){
        // sum = 0;
        // for(int e=s;e<n;e++){
        //   //loop over s,e

        //get sum and update max
        // }}
        //TC: O(n^3)  SC: O(1)
        //Idea 2: Carry forward sum info.
        //for(int s=0;s<n;s++){
        // sum = 0;
        // for(int e=s;e<n;e++){
        //   //loop over s,e
        //  sum += A[e]
        //  max =
        //get sum and update max
        // }}
        //TC: O(N^2) SC: O(1)
        //Idea 3: sum =
//        { 1,2,-4,5 , -6,7,8,9 }
//                      i
//        sum=-1
//                  ans = 5
        //TC: O(N) SC: O(1)
        int[] A = { -1,-2,-4,-5,-6,-7,-8,-9};
        System.out.println(maxSubarraySum(A));




    }
    public static int maxSubarraySum(int[] A){
        int n = A.length;
        int ans = Integer.MIN_VALUE , sum = 0;
        for(int i=0;i<n;i++){
            //A[i]
            //get sum.
            sum = sum + A[i];
            //update ans.
            ans = Math.max(ans,sum);
            //check
            if(sum<0){
                //reset
                sum = 0;
            }
        }
        return ans;
    }
}
