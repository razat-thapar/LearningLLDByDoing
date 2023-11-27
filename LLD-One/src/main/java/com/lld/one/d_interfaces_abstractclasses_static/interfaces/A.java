package com.lld.one.d_interfaces_abstractclasses_static.interfaces;

public interface A {
    //constants.
    public static final double PI = 22/7;

    //public abstract method
    public abstract void abstractMethod();

    //public static method.
    public static void staticMethod() {
        System.out.println("Inside Static method in interface, introduced in java 8");
    }
    // default method.
    public default void defaultMethod() {
        System.out.println("Inside default method in interface, introduced in java 8");
    }
    // private method.
    private void privateMethod(){
        System.out.println("Inside private method in interface, introduced in Java 9");
    }

    // private static method
    private static void privateStaticMethod() {
        System.out.println("Inside private static method in interface, introduced in Java 9");
    }
}
