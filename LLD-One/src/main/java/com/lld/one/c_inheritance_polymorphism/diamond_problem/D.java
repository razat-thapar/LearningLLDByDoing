package com.lld.one.c_inheritance_polymorphism.diamond_problem;

// D extends B,C is not allowed due to ambiguity in choosing common methods.
// This is solved using Interfaces.
public class D extends B/*,C*/{
    @Override
    public void fun() {
        System.out.println("D is having fun!");
    }
}
