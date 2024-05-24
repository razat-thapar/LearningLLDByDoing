package automation_anywhere;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
    public static void main(String[] args) {
        //input : cat is no act on tac for
        String input = "cat is no act on tac for";
        //output : cat act tac no on

        //B.F  :
        // cat , is , no , act, on  , tac , for
        // 2     1    0     2   0     2     0
        // 2     1    2     2   2     2      1
        //traverseal
        //cat, no, act, on , tac
        //boolean analgram( string s1, string s2)
        //Map<char,int>  m1   Map<char,int> m2
        //traverse keys on m1 and check if both have same freq
        // m1 and m2 size are same.
        // TC: O(3m)
        //TC: O(n+n^2*m+n)  SC: O(2m + n)
        System.out.println(getAllAnagrams(input));
    }
    public static List<String> getAllAnagrams(String input) {
        //words
        String[] words = getWords(input);
        int[] flag = new int[words.length];//all 0.
        for(int i=0; i<words.length; i++) {
            if(flag[i] != 0 ) {
                continue;
            }
            for(int j=i+1; j<words.length; j++) {
                if(flag[j]!=2 && isAnagram(words[i],words[j])){
                    flag[i]=2;
                    flag[j]=2;
                }
            }
        }
        //get all analgram
        List<String> result = new ArrayList<>();
        for(int i=0; i<words.length; i++) {
            if(flag[i]==2) {
                result.add(words[i]);
            }
        }
        return result;

    }
    public static String[] getWords(String sentence){
        return sentence.split(" ");
    }
    public static boolean isAnagram(String s1, String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            map1.put(s1.charAt(i),map1.getOrDefault(s1.charAt(i),0)+1);
        }
        for(int j=0;j<s2.length();j++){
            map2.put(s2.charAt(j),map2.getOrDefault(s2.charAt(j),0)+1);
        }
        if(map1.size()!=map2.size()){
            return false;
        }
        //compare maps.
        for(char c : map1.keySet()){
            if( !(map2.containsKey(c)  && map1.get(c)==map2.get(c))  ){
                return false;
            }
        }
        return true;
    }
}
