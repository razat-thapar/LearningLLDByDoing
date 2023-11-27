package com.lld.one.d_interfaces_abstractclasses_static.static_keyword;

public class Main {
    public static void main(String[] args) {
        //Scenario 1: Accessing static members using className.
        double x = -2.575;
        System.out.printf("Floor and ceil of %f is %f , %f %n",x,Math.getFloor(x),Math.getCeil(x));
        //Scenario 2: Accessing nested static class from outer class.
        Math.NestedMaths.display();
    }
}
