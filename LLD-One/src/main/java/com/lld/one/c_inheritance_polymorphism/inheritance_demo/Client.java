package com.lld.one.c_inheritance_polymorphism.inheritance_demo;

public class Client {
    public static void main(String[] args) {
        //Scenario 1: Sequence of constructor calling (parent vs child constructor)
        Instructor apurva = new Instructor();

        //Scenario 2: Private field of parent class inherited by child class but not accessible.
        Instructor razat = new Instructor("Razat",1,"razataggarwal");
        razat.addBatch("DSA");
        razat.printDetails();
    }
}
