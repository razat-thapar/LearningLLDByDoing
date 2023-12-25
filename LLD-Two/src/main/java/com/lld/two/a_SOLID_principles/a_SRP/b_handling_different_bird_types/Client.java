package com.lld.two.a_SOLID_principles.a_SRP.b_handling_different_bird_types;

public class Client {
    public static void main(String[] args) {
        //Case Study: Design a BIRD using OOP.
        //Approach 1: Make a class BIRD and then add all attributes and behaviours of all birds.
//        Bird sparrow = new Bird();
//        sparrow.fly();
//        Bird hen = new Bird();
//        hen.fly() ; // problem #1

        //PROBLEM:
        // now , we need to implement fly() method based on type of bird.

        //FIX 1:
        //using if-else, let's implemented behavior based on bird type.
        //Also, since, we are comparing each bird type , char by char comparison is error prone and slow,
        //let's make bird type as ENUM.
        Bird sparrow1 = new Bird(BirdType.Sparrow);
        sparrow1.fly();
        Bird hen1 = new Bird(BirdType.Hen);
        hen1.fly(); //works now.

        //Let's analyze it based on below parameters:
        //1. Readability / Understandability ? NO
            // if we have 100 + bird types, then each method is handling 100 if else cases and it's not easy to read.
            // code reviews by seniors will get delayed as it's challenging for them to read 1000 lines of code.
        //2. Maintainability ? NO
            // finding bugs is difficult as it's one huge class i.e., god class. and monster method.
            // we need to test the whole already working code again if we are adding just a small change.
        //3. Extensibility ? NO
            // If we try to add a new bird , then
            // merge conflicts can occur more often as multiple devs may be adding a new bird on same line in method.
            // if we try to modify existing code,
            // since, different bird types may share common variables , code , etc., changing behavior of one bird type
            // can lead to issues in another type i.e., Regression bugs , inconsistencies may occur if we modify some code.

        //PROBLEM: Not a good code design.
        //FIX: SOLID principles.
        //FIX 1: Using SRP (single responsibility principle)>
        //HOW :?  Let's split out god classes to different classes based on bird type.
        // let's split the monster methods like fly() based on bird type.
        // Use Inheritance.

    }
}
