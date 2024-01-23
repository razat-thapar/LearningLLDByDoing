package com.lld.one.k_streams_and_lambdas.e_streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //Streams demo.
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);
        //initializing
        Stream<Integer> s1 = list.stream();
        //operations on streams.
        //1. intermediate operations.
        //2  Terminal operations.

        //Use Case 1: filtering odd integers sorting and printing the list in descending order.
        s1.filter( (x) -> x%2 !=0 )
                .sorted( (Integer a, Integer b) -> a-b)
                .forEach( x -> System.out.println(x));

        //User Case 2: Find below a list of integers. Iterate over it and print every even number.
        System.out.println("------------------------------------------------------------");
        List<Integer> numbers2 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers2.stream().filter( x -> x%2==0).forEach( x -> System.out.println(x));

        //Use case 4:For a list of integers, return a list of the squares of each number.
        System.out.println("------------------------------------------------------------");
        List<Integer> numbers4 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> ans4 = numbers4.stream()
                .map( x -> x*x)
                .collect(Collectors.toList());
        System.out.println(numbers4); //numbers4 weren't modified due to collect method.
        System.out.println(ans4); //all modifications were stored in ans4
        

    }
}
