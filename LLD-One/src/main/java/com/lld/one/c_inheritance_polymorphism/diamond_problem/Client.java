package com.lld.one.c_inheritance_polymorphism.diamond_problem;

public class Client {
    public static void main(String[] args) {
        //gives error as D extends B,C not allowed.
        //D can inherit from only 1 class.
        D d = new D();
        d.fun();
    }
}
