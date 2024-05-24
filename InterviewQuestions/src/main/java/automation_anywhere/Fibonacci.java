package automation_anywhere;


import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    //fib(10)
    //0 1 2 3 5 8 11 ...
    //n = no of terms.
    //base case
//    fib(0) = empty
//            fib(1) = 0
//    fib(2) = 1
//    fib(3) = 1
//    fib(4) =
//    fib(n) = fib(n-1)+fib(n-2) , n>2
    //fib(3)
    //
    public static void main(String[] args) {
        int n = 5;
        int[] ans = new int[n+1];
        fibonacci(n, ans);
        for(int i=1;i<=n;i++){
            System.out.println(ans[i]);
        }
    }
    public static int fibonacci(int n , int[] ans) {
        //assumption: given n terms , print all the first n terms of fibonacci series.
        //base case.
        if(n==1){
            ans[n]=0;
            return 0;
        }
        if(n==2){
            ans[n]=1;
            return 1;
        }
        //break
        ans[n-2] = fibonacci(n-2,ans);
        ans[n-1] = fibonacci(n-1,ans);
        //System.out.printf("%d ,",sum);
        ans[n] = ans[n-1] + ans[n-1];
        return ans[n];
    }
}
