package Altimetrix;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstNonRecurringCharacter {
    public static Character firstNonRecurringCharacter(String str) {
        int[] charCount = new int[256]; // Assuming ASCII character set

        // First pass: count occurrences of each character
        for (char c : str.toCharArray()) {
            charCount[c]++;
        }

        // Second pass: find the first character with a count of 1
        for (char c : str.toCharArray()) {
            if (charCount[c] == 1) {
                return c;
            }
        }

        return null; // Return null if there is no non-recurring character
    }
    public static Character firstNonRecurringCharacterUsingStreamApi(String str){
        //first , build a freqMap
        //second, iterate over string , for each character, check if it's count ==1 , if yes, return character.
        Stream<Character> stream = str.chars().mapToObj(c->(char)c);
        Map<Character,Integer> freqMap = stream
                .collect(Collectors.toMap(
                        c->c,
                        c->1,
                        (a,b)->a+b
                ));
        Optional<Character> ans = str.chars().mapToObj(c->(char)c).filter(c->freqMap.get(c)==1).findFirst();
        return ans.orElse(null);
    }
    public static Character firstNonRecurringCharacterUsingStreamApi2(String str){
        //first , build a freqMap
        //second, iterate over string , for each character, check if it's count ==1 , if yes, return character.
        return str
                .chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(
                        c->c,
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry->entry.getValue()==1L)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null)
                ;
    }
    public static void main(String[] args) {
        String testStr = "swiss";
        Character result = firstNonRecurringCharacterUsingStreamApi2(testStr);
        if (result != null) {
            System.out.println("The first non-recurring character is: " + result);
        } else {
            System.out.println("There is no non-recurring character.");
        }
    }
}
