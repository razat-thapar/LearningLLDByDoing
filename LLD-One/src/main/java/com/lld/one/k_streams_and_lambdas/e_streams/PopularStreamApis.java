package com.lld.one.k_streams_and_lambdas.e_streams;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PopularStreamApis {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(12,13,234,23,003,238,23);
        Predicate<Integer> even = (num)->num%2==0;
        //even numbers list.
        List<Integer> evenList = integerList.stream().filter(even).collect(Collectors.toList());
        System.out.println(evenList);

        //odd numbers list.
        List<Integer> oddList = integerList.stream().filter(even.negate()).collect(Collectors.toList());
        System.out.println(oddList);

        //modify the data
        //double of each number.
        List<Integer> doubleList = integerList.stream().map(x->x*x).collect(Collectors.toList());
        System.out.println(doubleList);
        System.out.println("-------------------------------------");
        //sort the list in ascending order
        integerList.stream().sorted().forEach(System.out::println);
        System.out.println("-------------------------------------");
        //sort the list in reverse order.
        integerList.stream().sorted((a,b)->b-a).forEach(System.out::println);
        System.out.println("-------------------------------------");
        //see only 5th to 8th element range numbers.
        integerList.stream().sorted((a,b)->b-a).skip(4).limit(3).forEach(System.out::println);
        System.out.println("-------------------------------------");
        //to get sum of all numbers.
        int sum = integerList.stream().reduce(0,(a,b)->a+b).intValue();
        System.out.println("sum: "+sum);
        System.out.println("-------------------------------------");

        //another way to create stream
        int sum2 = IntStream.range(1,6).reduce(0,(a,b)->a+b);
        System.out.println("sum2: "+sum2);
        System.out.println("-------------------------------------");

        //another way to create stream
        int sum3 = Stream.of(1,2,3).reduce(0,(a,b)->a+b);
        System.out.println("sum3: "+sum3);
        System.out.println("-------------------------------------");

        //Demonstrating the use of reduce to perform
        //10 + 1
        //10 + 2
        //10 + 3
        //sum of above parallelly.

        //here it won't work as it will take only first function
        int sum4 = Arrays.asList(1,2,3).stream().reduce(10,(a, b)->a+b, (a, b)->a+b);
        System.out.println("sum : "+sum4);
        System.out.println("-------------------------------------");
        //here it will work as expected .
        int sum5 = Arrays.asList(1,2,3).parallelStream().reduce(10,(a, b)->a+b, (a, b)->a+b);
        System.out.println("sum using parallelStream: "+sum5);
        System.out.println("-------------------------------------");

        //stream api to print stats about stream of numbers.
        IntSummaryStatistics intSummaryStatistics = IntStream.rangeClosed(1,10).summaryStatistics();
        System.out.println(intSummaryStatistics);
    }
}
