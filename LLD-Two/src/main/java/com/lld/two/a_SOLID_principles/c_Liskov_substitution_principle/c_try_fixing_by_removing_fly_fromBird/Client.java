package com.lld.two.a_SOLID_principles.c_Liskov_substitution_principle.c_try_fixing_by_removing_fly_fromBird;

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
//        com.lld.two.a_SOLID_principles.a_SRP.b_handling_different_bird_types.Bird sparrow1 = new com.lld.two.a_SOLID_principles.a_SRP.b_handling_different_bird_types.Bird(com.lld.two.a_SOLID_principles.a_SRP.b_handling_different_bird_types.BirdType.Sparrow);
//        sparrow1.fly();
//        com.lld.two.a_SOLID_principles.a_SRP.b_handling_different_bird_types.Bird hen1 = new Bird(BirdType.Hen);
//        hen1.fly(); //works now.

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
        Sparrow sparrow = new Sparrow("twitty");
        sparrow.fly();
        sparrow.talk();
        Hen hen = new Hen("roster");
        hen.talk();

        //works !
        //Let's analyze it based on below parameters:
        //1. Readability / Understandability ? YES
            // if we have 100 + bird types, then we will have 100 classes.
            // code reviews by seniors will take place for each bird type one at a time.
            // new joiners can easily understand the code as it's single responsibility.
        //2. Maintainability ? YES
            // finding bugs are easy.
            // we no need to rerun test cases for already tested code but only for newly added changes.
        //3. Extensibility ? Yes
            // If we try to add a new bird , then
            // merge conflicts will occur less as multiple devs will be created new classes and will be assigned different bird types .
            // if we try to modify existing code,
            // each code entity have single responsibility, hence, any modification will not impact other parts of code.
            // no regression bugs

        //Scenario 2: Is it possible to add a Penguin Bird with no or minor modifications in old code ?
        //Approach 1: Create a new class Penguin and override Bird behaviors and add new attributes.
        //So, Yes, it's following OCP.
        Bird penguin = new Penguin("flappy");
        penguin.layEggs();

        //Scenario 3 : Liskov's Substitution Principle.
        // Def: Object of any child class should be as-is substitutable in a variant of parent type without making any code change.
        // Check Violation:
        // Try to perform subtyping and see if code breaks or not.
        // if code changes are required then Liskov's Substituion Principle violated.
        // If we want to store all types of Birds in a list and want to access fly() method.
        System.out.println("#####################LISKOV's Substitution##################################");
//        com.lld.two.a_SOLID_principles.c_Liskov_substitution_principle.a_problem_subtype_polymorphism.Bird penguin2 = new com.lld.two.a_SOLID_principles.c_Liskov_substitution_principle.a_problem_subtype_polymorphism.Penguin("Eric");
//        penguin2.fly(); // throws a Runtime exception here which is not expected by parent class.
//        penguin2.layEggs();
//        penguin2.talk();
        //VIOLATION OF LISKOV's

//        List<Bird> birds = List.of(new Penguin("flappy"),new Sparrow("twitty"),new Hen("Roster"));
//        for(Bird b : birds){
//            b.fly();
//        }

        //Problem : Penguin and Hen are showing unexpected behaviors for fly() while the behavior says they should fly().
                  // Client see's a conflict in expected and actual behavior.
        //How to fix this ?

            //Fix 1: Create a subclass of Bird name FlyableBird and add fly() method here instead of Bird class.
//            List<FlyableBird> birds = List.of(new Sparrow("twitty"));
//            for(FlyableBird b : birds){
//                b.fly();
//            }

                //Problem : Class Explosion.
                //Now, we will start creating groups among flyable bird based on behavior and this will end up in many classes
                //which could be avoided.

            //Fix 2: Remove fly() method from Bird class.
            Sparrow sparrow2 = new Sparrow("Twitty");
            sparrow2.fly();
            Eagle eagle = new Eagle("rocket");
            //eagle.fly();  //this is not present but it should exist.

                //Big Problem : We are not able to enforce fly() method on birds that can fly.

            //Fix 3: Create "Flyable" , "Danceable" , etc. interfaces based on behaviors.



    }
}
