package com.lld.one.k_streams_and_lambdas.e_streams;

import java.util.HashMap;
import java.util.Map;

public class StreamsApiOnMap {
    public static void main(String[] args) {
        //Map datastructure.
        Map<Long,String> map = new HashMap<>();
        map.put(1L,"Razat1");
        map.put(2L,"Razat2");
        map.put(3L,"Razat3");
        map.put(4L,"Razat4");
        map.put(5L,"Razat5");
        //NOTE: map doesn't extend collection<E> interface which contains the stream method.
        //we can directly use stream method.

        //using entrySet() method
        //Use case : iterate over keys.
        map.entrySet().stream().map(Map.Entry::getKey).forEach(System.out::println);
        System.out.println("-----------------------------------------------------");
        //Use case :: iterate over values.
        map.entrySet().stream().map((key)->{return "value";}).forEach(System.out::println);
        System.out.println("-----------------------------------------------------");
        //Use case :: iterate over values which have key even numbered.
        map.entrySet().stream().filter(x->x.getKey()%2==0).map(Map.Entry::getValue).forEach(System.out::println);
        System.out.println("-----------------------------------------------------");
    }
}
