package Altimetrix;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalancedString {
    //given a string s of brackets '(', ')', '{', '}', '[' and ']', determine if the input string is balanced.
    // (i.e,. every opening bracket has a corresponding closing bracket of the same type order doesn't matter)
    private List<Bracket> bracketList = List.of(
            new Bracket('(', ')'),
            new Bracket('{', '}'),
            new Bracket('[', ']')
    );
    public class Bracket{
        Character open;
        Character close;
        public Bracket(Character open, Character close){
            this.open = open;
            this.close = close;
        }
    }
    public boolean isBalanced(String s) {

        Map<Character,Integer> bracketCount = new HashMap<>();
        for(int i=0;i<s.length();i++){
            Character ch = s.charAt(i);
            int freq = bracketCount.getOrDefault(ch, 0);
            bracketCount.put(ch, freq+1);
        }
        for(Bracket bracket: bracketList){
            int openCount = bracketCount.getOrDefault(bracket.open, 0);
            int closeCount = bracketCount.getOrDefault(bracket.close, 0);
            if(openCount != closeCount){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BalancedString balancedString = new BalancedString();
        String s1 = "{[()]}";// true
        String s2 = "{[)](}";// true
        String s3 = "[]()}";// false
        System.out.println(balancedString.isBalanced(s1));
        System.out.println(balancedString.isBalanced(s2));
        System.out.println(balancedString.isBalanced(s3));
    }


}
