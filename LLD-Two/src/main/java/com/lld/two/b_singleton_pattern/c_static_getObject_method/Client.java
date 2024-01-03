package com.lld.two.b_singleton_pattern.c_static_getObject_method;

public class Client {
    public static void main(String[] args) {
        //Objective : Need to create only one object for a class , if already created then return the same object.
        //Idea 1: since, we want to restrict creation of object , so make constructor private.

        //SingletonClass obj = new SingletonClass(); //error

        //Problem: How to access the constructor outside the class to create one object ?

        //Idea 2:  public getObject() method and private reference variable.
        // We can access the private constructor inside same class,
        // so let's make a method that will create object and return the same if not already created.
        // we need to store the object , so let's create a reference variable.

        //SingletonClass obj = getObject(); // error can't access it without object.

        // let's make the method static.

        //Idea 3: public static getObject() method and private reference variable.
        //since, we can't access non-static variables from static methods, hence, we need to make
        // reference variable static as well.

        SingletonClass obj = SingletonClass.getObject(); //works now!
        System.out.println(obj);

        //Problem : Not thread safe.
        // t1 and t2 threads can access getObject() method at same time and for both if condition is false.
        // say t2 gets preempted while t1 creates the object , now, condition is true ,
        // ideally, t2 should not create object but if t2 resumes it will create a new object.

        //Idea 4: Apply mutex lock on whole method body
        // so that only 1 thread enters the critical section.

        
    }
}
