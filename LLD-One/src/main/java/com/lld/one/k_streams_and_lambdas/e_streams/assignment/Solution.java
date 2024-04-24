package com.lld.one.k_streams_and_lambdas.e_streams.assignment;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        //Q1:Find below a list of integers. Iterate over it and print the square of each number.
        List<Integer> integerList = List.of(1,2,3,4,5,6,7,8);
        integerList.forEach(x-> System.out.printf("%d,",x*x));
        System.out.println();
        //Q2:Find below a list of integers. Iterate over it and print every even number.
        integerList.forEach(x->{if(x%2==0) System.out.printf("%d,",x);});
        System.out.println();
        //Q3:For the list of integers, find all the even numbers. Then, iterate over the even numbers and print each number.
        integerList.stream().filter(x->x%2==0).forEach(x-> System.out.printf("%d,",x));
        System.out.println();
        //Q4:For a list of integers, return a list of the squares of each number.
        List<Integer> newIntegerList = integerList.stream().map(x->x*x).collect(Collectors.toList());
        System.out.println(newIntegerList);
        //Q5:For a list of strings, return a list of the length of each string.
        List<String> stringList = List.of("Tantia Tope", "Rani Lakshmibai", "Mangal Pandey", "Nana Sahib");
        List<Integer> stringLengthList = stringList.stream().map(str->str.length()).collect(Collectors.toList());
        System.out.println(stringLengthList);
        //Q6:For a list of strings, filter out the strings which do not start with the letter T and then uppercase the remaining strings.
        List<String> newStringList = stringList.stream().filter(str->str.charAt(0)=='T' || str.charAt(0)=='t').map(str->str.toUpperCase()).collect(Collectors.toList());
        System.out.println(newStringList);
        //Q7.For a list of strings, filter out the strings which do not start with the letter T, then uppercase the remaining strings and then sort them.
        stringList.stream().filter(str->str.charAt(0)!='T' && str.charAt(0)!='t').map(str->str.toUpperCase()).sorted().forEach(str-> System.out.printf("%s,",str));
        System.out.println();
        //Q8.For a list of integers, find the sum of all the numbers.
        int sum=0;
        sum = integerList.stream().reduce(sum,(x,y)->x+y);
        System.out.println(sum);
        //Q9.For a list of integers, find the sum of the squares of all the numbers.
        sum=0;
        sum = integerList.stream().map(x->x*x).reduce(sum,(x,y)->x+y);
        System.out.println(sum);
        //Q10. For a list of integers, find the sum of the squares of all the even numbers.
        sum=0;
        sum = integerList.stream().filter(x->x%2==0).map(x->x*x).reduce(sum,(x,y)->x+y);
        System.out.println(sum);
        //Q11. Given a list of numbers, find the maximum number in the list.
        int max = 0;
        System.out.println(integerList.stream().reduce(max,(x,y)->(x>=y)?x:y));
        Optional<Integer> maximum = integerList.stream().max((x, y)->x-y);
        System.out.println(maximum.get());
        //Q12. Given a list of numbers with duplicates, find the distinct numbers in the list.
        integerList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5);
        integerList.stream().distinct().forEach(x-> System.out.printf("%d,",x));
        System.out.println();
        //Q13. Given a list of numbers, find the average of all the numbers.
        sum = 0;
        sum = integerList.stream().reduce(sum,(x,y)->x+y);
        System.out.printf("avg = %d%n",sum/ integerList.size());
        //Q14. Give a list of strings, find the average length of all the strings.
        sum = 0;
        sum = stringList.stream().map(str->str.length()).reduce(sum,(x,y)->x+y);
        System.out.printf("avgLength = %d%n",sum/ stringList.size());
        //Q15. Given a list of strings, find the first string that is longer than 10 characters.
        stringList.stream().filter(str->str.length()>10).limit(1).forEach(str-> System.out.println(str));
        Optional<String> firstString = stringList.stream().filter(str->str.length()>10).findFirst();
        System.out.println(firstString);

    }
}
