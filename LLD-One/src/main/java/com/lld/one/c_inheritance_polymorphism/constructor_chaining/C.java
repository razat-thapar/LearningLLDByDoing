package com.lld.one.c_inheritance_polymorphism.constructor_chaining;

public class C extends B{
    public C(){
        // java is making implicit super() call .
        System.out.println("Default constructor called in C");
    }
    public C(int c){
        super(c);
        System.out.println("Parameterized constructor called in C");
    }
}
