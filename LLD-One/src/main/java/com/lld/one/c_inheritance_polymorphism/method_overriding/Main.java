package com.lld.one.c_inheritance_polymorphism.method_overriding;

public class Main {
    public static void main(String[] args) {
        //Scenario 1: Subtyping of different objects.
        ////calling same fly() method on Bird reference variables yields different behaviour based on type of object
        //The behavior of fly() is resolved at runtime only.
        //Hence, this is dynamic polymorphism.
        Bird b1=  new Bird();
        Bird b2 = new Sparrow();
        b1.fly();
        b2.fly();
        //Scenario 2 : Scenario 1 + making both parent and child method as static.
        // here, both yielded same behavior i.e., that of reference variable.
        // why ?  because it was made static hence, class method and not object method.
        // hence, this is resolved at compile time.
        b1.hunt();
        b2.hunt();

        //Scenario 3: Storing Parent object in child class reference variable
        // It will throw exception as this is not allowed in java.
        Sparrow sp = (Sparrow) new Bird();
        sp.fly();
        sp.hunt();

    }

}
