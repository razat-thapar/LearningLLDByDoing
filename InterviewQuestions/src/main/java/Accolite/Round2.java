package Accolite;

import java.util.HashMap;
import java.util.Map;

public class Round2 {
    public static void main(String[] args) {
        String input = "";
        System.out.printf("Input: %s%n",input);
        System.out.printf("Output: %s%n",longestNonRepeatingSubstring(input));
    }
    public static String longestNonRepeatingSubstring(String input){
        Map<Character,Integer> hm = new HashMap<>();
        int ans_s=1,ans_e=0,s=0,e=0, n= input.length(), len ,ans_len,freq;
        if(n==0){
            return "";
        }
        //intialiize
        hm.put(input.charAt(e),1);

        while(e<n){
            //update ans.
            len= e-s+1;
            if(hm.size()==len){
                ans_len = ans_e - ans_s + 1;
                if(ans_len < len){
                    ans_s = s;
                    ans_e = e;
                }
                //add more characters.
                e++;
                if(e==n){
                    break;
                }
                if(hm.containsKey(input.charAt(e))){
                    hm.put(input.charAt(e),1+hm.get(input.charAt(e)));
                }else{
                    hm.put(input.charAt(e),1);
                }
            }else{
                //remove
                freq = hm.get(input.charAt(s));
                if(freq==1){
                    hm.remove(input.charAt(s));
                }else{
                    hm.put(input.charAt(s),freq-1);
                }
                s++;
            }
        }
        //iterate and get string.
        StringBuilder sb = new StringBuilder();
        for(int i=ans_s;i<=ans_e;i++){
            sb.append(input.charAt(i));
        }
        return sb.toString();
    }
}
