package com.lld.one.c_inheritance_polymorphism.constructor_chaining;

public class Client {
    public static void main(String[] args) {
        // Scenario 1: calling default constructor of D.
        // D->C->B->A
        //sequence of calling is :
        /*
            Default Constructor called in A
            Default constructor called in B
            Default constructor called in C
            Default constructor called in D
         */
        D d = new D();

        // Scenario 2: calling parameterized constructor of D.
        /*
            Default Constructor called in A
            Parameterized constructor called in B
            Parameterized constructor called in C
            Parameterized constructor called in D
         */
        D d2 =  new D(5);
    }
}
