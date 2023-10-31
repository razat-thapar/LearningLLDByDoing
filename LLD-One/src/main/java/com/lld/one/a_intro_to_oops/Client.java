package com.lld.one.a_intro_to_oops;

public class Client {
    public static void main(String[] args){
        // Scenario 1: Creating student and batch objects and manually injecting dependency.
        Student s1 = new Student(1,"Razat",26);
        Batch b1 = new Batch("Intermediate","Rahul Grover");
        s1.setBatch(b1);
        Student s2 = new Student(2,"Sidharth",25);
        Batch b2 = new Batch("Begineer","Deepak");
        s2.setBatch(b2);
        // Scenario 2: Printing an object without overriding toString() method.
        System.out.println(s1);
        // prints it's Fully qualified class name @ address
        // com.lld.one.a_intro_to_oops.Student@682a0b20
        System.out.println(b1);
        // Scenario 3: Printing an object with overridden toString() method.
        System.out.println(s1);
        System.out.println(b1);
        // Scenario 4: Call by Reference vs Call by value in java.
        /*
            Swap() test to validate that java is always CALL BY VALUE !
            Reference Variable stores actual memory address of the object.
         */
        //pass by value.
        System.out.println("Testing pass by reference vs pass by value");
        swap(s1,s2);
        System.out.println(s1);
        //swap didn't work as expected since, we made a copy of actual parameters and swapped memory addresses in the copy only.
    }
    public static void swap(Student s1 , Student s2){
        Student temp = s1;
        s1=s2;
        s2=temp;
    }
}
