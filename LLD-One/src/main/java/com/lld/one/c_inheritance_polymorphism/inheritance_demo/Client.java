package com.lld.one.c_inheritance_polymorphism.inheritance_demo;

public class Client {
    public static void main(String[] args) {
        Instructor razat = new Instructor("Razat",1,"razataggarwal");
        razat.addBatch("DSA");
        razat.printDetails();
    }
}
