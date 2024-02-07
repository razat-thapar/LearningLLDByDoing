package com.lld.one.k_streams_and_lambdas.e_streams.operations;

import java.util.Arrays;
import java.util.List;

public class ForEach {
    public static void main(String[] args) {
        //for each : A terminal operation.
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        //Purpose: to iterate over the list and apply consumer lambda function.
        list.stream().forEach(x -> System.out.println(x));
        //1. Convert the list to a stream.
        //2. for each element of stream.
        //3. we pass it to consumer (lambda) and do something.
        //4. finally, we stop
        //NOTE: Original list is not modified.
        System.out.println(list);
    }
}
