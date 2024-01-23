package com.lld.one.k_streams_and_lambdas.e_streams.operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Filter {
    public static void main(String[] args) {
        //Stream Creation.
        List<Integer> list = Arrays.asList(13,34,23,56,2390,3);
        System.out.println(list);
        //apply filter operation to filter out desired values. (Here, Odd values)
        List<Integer> oddList = list.stream().filter(num -> num%2!=0).toList();
        //internal steps involved here.
        //1. a stream object wrapped over List<Integer> is created.
        //2. for each element in stream,
        //3. we ask the filter to check lambda(predicate) condition.
        //4. if true :  keep the element in stream.
        //5. if false : remove the element from stream.
        //6. finally, the modified stream is converted to List.
        //NOTE: Original List is not modified.
        System.out.println(oddList);

    }
}
