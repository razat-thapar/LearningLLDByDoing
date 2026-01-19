package gs;

public class Palindrome {
    public static void main(String[] args) {
        //String s = "adobeCodeBanc"
        //String t = "abc"
        //            a
        //            aa
        //case insenstitive.
        //duplicates might be present , so we need all the duplicate occurences in s .
        //only eng alphas.
        //find min length substring having all the characters.

        // babab
        // baab
        // i  j

        // bababad
        // bbb
        //find the longest palindromic substring .
        //lowercase
        //B.F  consider all substrings and check whether the substring [s,e] is palindromic or not , if yes then update ans.
        //int ans_s=0, ans_e =-1
        //StringBuilder ans
        // TC: O(n^2 * n/2 * )    SC: O(1)
        String s = "babadada";
        System.out.printf("Longest Substring of %s is : = %s%n",s,getLongestPalindromicSubstring(s));

    }
    public static String getLongestPalindromicSubstring(String input){
        StringBuilder ans = new StringBuilder();
        int ans_s=0, ans_e=-1,ans_len=0, n = input.length(),len;
        for(int s=0;s<n;s++){
            for(int e=s;e<n;e++){
                //s,e
                if(isPalindrome(input,s,e)){
                    //udpate ans.
                    len = e-s+1;
                    if(len>ans_len){
                        ans_s = s;
                        ans_e = e;
                        ans_len = len;
                    }
                }
            }
        }
        //get final string.
        for(int i=ans_s;i<=ans_e;i++){
            ans.append(input.charAt(i));
        }
        return ans.toString();
    }

    private static boolean isPalindrome(String input, int s, int e) {
        //two pointesr.
        while(s<e){
            if(input.charAt(s)!=input.charAt(e)){
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}
