package epam;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
//        String input = "dabfcadef";
//        Map<Character, Long> map = input.chars().mapToObj(obj->(char)obj).collect(Collectors.groupingBy(Character::charValue,Collectors.counting()));
//        //filter the char sequence
//        String ans = input.chars().mapToObj(obj->(char)obj).filter((character -> map.get(character)==1)).map(ch->String.valueOf(ch)).collect(Collectors.joining());
//        System.out.println(ans);
        String str1 = "abcdef";
        int[] list = {1,2,3,4};
       Stream<Integer> stream = Arrays.stream(list).boxed();
       //filtering odd numbers.
        Stream<Integer> stream2 = stream.filter((x)->x%2!=0);
        System.out.println(stream2.count());
    }
}
