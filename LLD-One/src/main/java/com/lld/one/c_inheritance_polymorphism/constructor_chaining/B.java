package com.lld.one.c_inheritance_polymorphism.constructor_chaining;

public class B extends A{
    private int b;
    public B(){
        // java is making implicit super() call .
        System.out.println("Default constructor called in B");
    }
    public B(int b){
        // java is making implicit super() call .
        this.b=b;
        System.out.println("Parameterized constructor called in B");
    }
}
