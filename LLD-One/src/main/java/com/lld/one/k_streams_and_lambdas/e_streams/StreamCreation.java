package com.lld.one.k_streams_and_lambdas.e_streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Stream.builder;

public class StreamCreation {
    public static void main(String[] args) {
        //### Way 1 : arrays to stream
        Integer[] nums = {1,2,3,4,5};
        Stream<Integer> stream1 = Stream.of(nums);

        //### Way 2: items to stream
        Stream<Integer> stream2 = Stream.of(1,2,3,4,5);

        //### Way 3: Collections to stream
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> stream3 = list.stream();

        //### Way 4: Use Builder pattern to create stream
        Stream.Builder<Integer> builder = Stream.builder();
        builder.add(1);
        builder.add(2);
        builder.add(3);
        Stream<Integer> stream4 = builder.build();

    }
}
