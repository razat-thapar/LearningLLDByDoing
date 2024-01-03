package com.lld.two.b_singleton_pattern.a_private_constructor;

public class Client {
    public static void main(String[] args) {
        //Objective : Need to create only one object for a class , if already created then return the same object.
        //Idea 1: since, we want to restrict creation of object , so make constructor private.

        //SingletonClass obj = new SingletonClass(); //error

        //Problem: How to access the constructor outside the class to create one object ?

        //Idea 2: We can access the private constructor inside same class, so let's make a method that will create object and return the same if not already created.

    }
}
