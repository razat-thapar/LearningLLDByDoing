package vlink;

public class StringOccurences {
    public static void main(String[] args) {
        String input = "aabbbccddaaabbccceeff";
        //String output = "a3b3c2d2a3b2c3e2f2";
        System.out.printf("Input: %s %n Output: %s\n", input,process(input));
    }
    public static String process(String input){
        StringBuilder ans = new StringBuilder();
        int count = 0;
        int i=0,j=0;
        int n = input.length();
        char ch1,ch2;
        while(i<n){
            ch1 = input.charAt(i);
            count=0;
            j=i;
            while(j<n && ch1==input.charAt(j)){
                count++;
                j++;
            }
            ans.append(ch1);
            ans.append(count);
            //move i
            i=j;
        }
        return ans.toString();
    }
}
