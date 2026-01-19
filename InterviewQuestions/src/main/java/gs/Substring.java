package gs;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class Substring {
    public static void main(String[] args) {
        //String s = "adobeCodeBanc"
        //String t = "aabc"
        //Map<char,int>
        //a-1

        //   adob
        //Map<Character,Integer> freq1
        //contian only lowercase
        //if we have upper case , then first we convert it to lower and store.
        //a-0
        //d-1
        //o-1
        //b-0
        //return false;

        //            a
        //            aa
        //case insenstitive.
        //duplicates might be present , so we need all the duplicate occurences in s .
        //only eng alphas.
        //find min length substring having all the characters.
        //B.F Consider all the substrings and for each substring [s,e] , we have to compare substring with t , and if all characters in t are present in substring.
        //then update int ans_s , ans_e , ans_len
        //n first
        //m second
        // TC: O(n^2 * Max(n,m) )  SC: O(52)



        //Idea2 : eliminating some substrings.
        //TC: O(2N * 1 + M)  SC: O(52 + 52 )
        String input1 = "abbbACda";
        String input2 = "aa";
        System.out.printf("The min Length substring of %s is %s ",input1,minLengthSubstring(input1,input2));


    }
    public static String minLengthSubstring(String str1, String str2){
        int n = str1.length(), m = str2.length();
        int s = 0 , e = 0 , ans_s=0, ans_e=-1 , ans_len = Integer.MAX_VALUE , len , countMatching=0;
        Map<Character,Integer> freq1 = new HashMap<>();
        Map<Character,Integer> freq2 = new HashMap<>();
        Predicate<Character> isUpper = ch -> (ch>='A') && (ch<='Z');
        //ch-'A'+'a';
        //populate freq2 using str2.
        char ch;
        for(int i=0;i<m;i++){
            ch = str2.charAt(i) ;
            if(isUpper.test(ch)){
                ch = (char)(ch-'A'+'a');
            }
            if(freq2.containsKey(ch)){
                freq2.put(ch,1+freq2.get(ch));
            }else{
                freq2.put(ch,1);
            }
        }
        //initialize freq1
        ch = str1.charAt(0);
        if(isUpper.test(ch)){
            ch = (char)(ch-'A'+'a');
        }
        if(freq2.containsKey(ch)){
            freq1.put(ch,1);
            countMatching++;
        }
        while(e<n){
            //check
            if(countMatching==m){
                //update ans.
                len = e-s+1;
                if(len<ans_len){
                    ans_s= s;
                    ans_e = e;
                    ans_len = len;
                }
                //remove chars.
                ch = str1.charAt(s);
                if(isUpper.test(ch)){
                    ch = (char)(ch-'A'+'a');
                }
                if(freq2.containsKey(ch)){
                    countMatching--;
                    freq1.put(ch,freq1.get(ch)-1);
                }
                s++;
            }else{
                //add more chars.
                e++;
                if(e==n){
                    break;
                }
                ch = str1.charAt(e);
                if(isUpper.test(ch)){
                    ch = (char)(ch-'A'+'a');
                }
                if(freq2.containsKey(ch)){
                    if(freq1.containsKey(ch)){
                        freq1.put(ch,1+freq1.get(ch));
                    }else{
                        freq1.put(ch,1);
                    }
                    countMatching++;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        //get final string.
        for(int i=ans_s;i<=ans_e;i++){
            ans.append(str1.charAt(i));
        }
        return ans.toString();
    }

}
