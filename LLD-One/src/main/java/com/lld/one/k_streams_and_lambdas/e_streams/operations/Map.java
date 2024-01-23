package com.lld.one.k_streams_and_lambdas.e_streams.operations;

import java.util.Arrays;
import java.util.List;

public class Map {
    public static void main(String[] args) {
        //Stream Creation.
        List<String> list = Arrays.asList("Raj","Anurag","Prateek","Abdul","Kalam","TatiyaTope");
        System.out.println(list);
        //Requirement:
        //Need to convert our datasource to another type without modifications in datasource.
        //e.g. List<String>   to   List<Integer>
        List<Integer> lenList = list.stream().map( str -> str.length()).toList();
        //internal steps involved here.
        //1. a stream object wrapped over List<String> is created.
        //2. for each element in stream,
        //3. we ask the map to convert element using lambda(function)
        //4. we get a stream of another type.
        //5. finally, the modified stream is converted to List.
        //NOTE: Original List is not modified.
        System.out.println(lenList);
    }
}
