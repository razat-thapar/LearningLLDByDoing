package com.lld.one.c_inheritance_polymorphism.method_overloading;

public class Client {
    public static void main(String[] args) {
        //Scenario 1: Demonstrating Method Overloading. Same name but different arguments (types)
        Calculator cal = new Calculator();
        System.out.println(cal.add(23,43));
        System.out.println(cal.add(23.5,32));
        //Scenario 2: Demonstrating Method Overloading. Same name but different arguments (count)
        System.out.println(cal.add(3,4,2));
        System.out.println(cal.add(3,4,5,3,3));
        //Scenario 3: Demonstrating Method Overloading using varargs.
        System.out.println(cal.add(23,43,23,32));
        System.out.println(cal.add(23.234,234.8,2.3,3.23,3.2));
    }
}
