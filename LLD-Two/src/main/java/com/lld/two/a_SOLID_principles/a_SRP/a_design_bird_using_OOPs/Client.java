package com.lld.two.a_SOLID_principles.a_SRP.a_design_bird_using_OOPs;

import com.lld.two.a_SOLID_principles.a_SRP.b_handling_different_bird_types.BirdType;

public class Client {
    public static void main(String[] args) {
        //Case Study: Design a BIRD using OOP.
        //Approach 1: Make a class BIRD and then add all attributes and behaviours of all birds.
        Bird sparrow = new Bird();
        sparrow.fly();
        Bird hen = new Bird();
        hen.fly() ; // problem #1

        //PROBLEM:
        // now , we need to implement fly() method based on type of bird.

        //FIX 1:
        //using if-else, let's implemented behavior based on bird type.
        //Also, since, we are comparing each bird type , char by char comparison is error prone and slow,
        //let's make bird type as ENUM.


    }
}
