package automation_anywhere;

public class PowerOfTen {
    public boolean isPowerOfTen(int n){
        if(n<=0){
            return false;
        }
        if(n==1){
            return true;
        }
        return (n%10==0);
    }
}
