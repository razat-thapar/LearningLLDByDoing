package com.lld.one.o_java8_optional;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        //Traditional way before java 7.
        Integer i1 = 10;
        Integer i2 = 20;
        add(i1,i2);
        //Problem : What if anyone is null.
        //add(null,12); //null pointer exception.
        //Java 8 Optional fix.
        Optional<Integer> o1 = Optional.ofNullable(10);
        Optional<Integer> o2 = Optional.ofNullable(20);
        add(o1,o2);
        //check for null.
        add(Optional.ofNullable(null),Optional.ofNullable(12));
        //This is not throwing any exception now as it's making the null to zero and adding.
    }
    public static void add(Integer i1, Integer i2){
        System.out.println(i1+i2);
    }
    public static void add(Optional<Integer> o1, Optional<Integer> o2){
        Integer i1 = o1.orElse(0);//if it's null then replace it with 0
        Integer i2 = o2.orElse(0);////if it's null then replace it with 0
        System.out.println(i1+i2);
    }


}
