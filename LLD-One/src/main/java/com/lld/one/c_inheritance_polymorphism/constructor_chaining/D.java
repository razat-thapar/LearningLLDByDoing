package com.lld.one.c_inheritance_polymorphism.constructor_chaining;

public class D extends C{
    private int d;
    public D(){
        // java is making implicit super() call .
        System.out.println("Default constructor called in D");
    }
    public D(int d){
        super(d);
        this.d=d;
        System.out.println("Parameterized constructor called in D");
    }
}
