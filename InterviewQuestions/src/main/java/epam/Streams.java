package epam;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        String input = "dabfcadef";
        Map<Character, Long> map = input.chars().mapToObj(obj->(char)obj).collect(Collectors.groupingBy(Character::charValue,Collectors.counting()));
        //filter the char sequence
        String ans = input.chars().mapToObj(obj->(char)obj).filter((character -> map.get(character)==1)).map(ch->String.valueOf(ch)).collect(Collectors.joining());
        System.out.println(ans);
    }
}
