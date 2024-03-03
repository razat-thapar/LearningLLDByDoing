package miscellaneous;

public class Main {
    public static void main(String[] args) {
        int[] A = {16,4,3,5,2};
        System.out.println(countSpecialPairs(A));
    }
    public static int countSpecialPairs(int[] A){
        //TC: O(N*64) SC: O(32)
        int ans = 0 , msb;
        int n = A.length;
        int[] unsetBitCount = new int[31];
        for(int i=n-1;i>=0;i--){
            //A[i]
            if(A[i]==0){
                ans += n-1-i; //all numbers in right can combine.
            }else {
                //get msb bit pos of A[i]
                msb = getMSB(A[i]);
                ans += unsetBitCount[msb];
            }
            //update unsetBitCount array.
            updateUnsetBitCount(unsetBitCount,A[i]);
        }

        return ans;
    }
    public static void updateUnsetBitCount(int[] unsetBitCount, int num){
        for(int i=0;i<=30;i++){
            //check if ith bit is unset in num
            if((num& (1<<i))==0){
                unsetBitCount[i]++;
            }
        }
    }
    public static int getMSB(int num){
        int ans = 0;
        for(int i=30;i>=0;i--){
            //check the leftmost set bit
            if((num&(1<<i))!=0){
                ans = i;
                break;
            }
        }
        return ans;
    }
}
