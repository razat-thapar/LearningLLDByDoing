package com.lld.one.i_generics.a_why_generics;

public class Main {
    public static void main(String[] args) {
        //Scenario 1 :  Object Pair.
        ObjectPair p1 = new ObjectPair(1,"Razat");
        ObjectPair p2 = new ObjectPair(1.3,3);
        System.out.println(p1);
        System.out.println(p2);
        //b is of type String as per input.
        System.out.println(((String)p1.b).length());
        //problems with this appraoch:
        //1.
    }
}
