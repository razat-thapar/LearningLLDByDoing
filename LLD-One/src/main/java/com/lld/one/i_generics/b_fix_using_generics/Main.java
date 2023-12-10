package com.lld.one.i_generics.b_fix_using_generics;

public class Main {
    public static void main(String[] args) {
        //scenario 1: Wrapper classes passed as parameters
        GenericPair<Integer,String> gp1 = new GenericPair<>(2,"Razat");
        System.out.printf("id : %d, name : %s ",gp1.getFirst(),gp1.getSecond());
        //scenario 2: primitive types passed as parameters
        //primitive types as parameters are not allowed !
        //GenericPair<int,char> gp2 = new GenericPair<>(2,'a');
    }
}
