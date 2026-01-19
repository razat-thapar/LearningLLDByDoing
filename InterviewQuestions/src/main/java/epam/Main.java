package epam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        // Given a sentence find the word that has the 2nd highest length.
//        String input = "I am interested to grow in my organization";
//        //delimiter : space
//        //B.F  first extract all the words into List<String> words by traversing each char from left to right and once space is encounted we will store the word.
//        //StringBuilder word = "";
//        //
//        // sorting of list based on length of string in desc order and get the 1th index string
//        String word = Arrays.stream(input.split(" ")).sorted((a,b)->b.length()-a.length()).skip(1).findFirst().get();
//        String word2 = Arrays.stream(input.split(" ")).sorted(Comparator.comparing(String::length).reversed()).skip(1).findFirst().get();
//        System.out.println(word);
//        System.out.println(word2);

        // Given a sentence, find the number of occurrence of each word.
        String input = "the quick brown fox jumps right over the little lazy dog little";
        Map<String,Long> map = Arrays.stream(input.split(" ")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(map);

    }
}
