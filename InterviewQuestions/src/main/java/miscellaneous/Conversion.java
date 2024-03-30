package miscellaneous;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Conversion {
    public static void main(String[] args) {
        String input="t28o23 S123caler9023 W2323elcome";
        System.out.printf("input : %s%n",input);
        System.out.printf("output: %s%n",convert(input));
    }
    public static String convert(String input){
        StringBuffer output = new StringBuffer();
        StringBuffer word = new StringBuffer();
        int n = input.length();
        TreeMap<Integer,String> wordMap = new TreeMap<>();
        int num = 0 , i=0;
        char ch ;
        while(i<n){
            ch = input.charAt(i);
            if( (ch >='a' && ch<='z') || (ch >='A' && ch<='Z') ){
                word.append(ch);
                i++;
            }else if(ch>='0' && ch<='9'){
                while(i<n && input.charAt(i)>='0' && input.charAt(i)<='9'){
                    //get num.
                    num = num*10 + (input.charAt(i)-'0');
                    i++;
                }
            }else {
                //we got the word and num.
                wordMap.put(num, word.toString());
                //reset.
                word = new StringBuffer();
                num = 0;
                //skip all white spaces.
                while(i<n && input.charAt(i)==' '){
                    i++;
                }
            }
        }
        //to put the last word.
        if(word.isEmpty()==false){
            //we got the word and num.
            wordMap.put(num, word.toString());
            //reset.
            word = new StringBuffer();
        }
        System.out.println(wordMap);
//        //iterate over keys in ascending order and append to ans.
        for(Integer key : wordMap.keySet()){
            output.append(wordMap.get(key));
            //add a space. if not a last word.
            if(key!= wordMap.lastKey()) {
                output.append(' ');
            }
        }
        return output.toString();
    }
}
