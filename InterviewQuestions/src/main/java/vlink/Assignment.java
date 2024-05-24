package vlink;

import java.util.HashMap;
import java.util.Map;

public class Assignment {
    public static void main(String[] args) {
        String str = "";
        String ans = maxNonRepeatingSubstring(str);
        System.out.printf("Ans = %s%n",ans);
    }
    public static String maxNonRepeatingSubstring(String str) {
        int n  = str.length();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int s=0,e=0;
        int ans_len = 0 , len;
        int ans_s=0, ans_e=-1;
        char ch;
        while(e<n){
            if(map.containsKey(str.charAt(e))){
                //remove characters from start.
                ch = str.charAt(s);
                if(map.get(ch)==1){
                    map.remove(ch);
                }else{
                    map.put(ch,map.get(ch)-1);
                }
                s++;
            }else{
                //add more characters.
                ch = str.charAt(e);
                if(map.containsKey(ch)){
                    map.put(ch,map.get(ch)+1);
                }else{
                    map.put(ch,1);
                }
                //update ans.
                len = e-s+1;
                if(len > ans_len){
                    ans_s=s;
                    ans_e=e;
                    ans_len = len;
                }
                e++;
            }
        }
        //ans.
        StringBuilder sb = new StringBuilder();
        for(int i=ans_s;i<=ans_e;i++){
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
