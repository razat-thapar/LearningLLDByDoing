package com.lld.one.i_generics.c_generic_methods;

public class Main {
    public static void main(String[] args) {
        int x = getSomething(23);
        String y = getSomething(43);

    }
    private static <T> void printSomething(T obj){
        System.out.println(obj);
    }
    static <T,T2> T2 getSomething(T t){
        return (T2)t;
    }
}
