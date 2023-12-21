package com.lld.two.c_builder_pattern.a_multi_params_problem;

import java.util.Date;

public class InstructorClient {
    public static void main(String[] args) {
        //Scenario 1: Create a student object with name, psp, batch .
        //validations:
        // psp between [0,100]
        // batch follows some regex.
        Student s1 = new Student();
        s1.name= "Razat";
        s1.batch = "intermediatefeb23";
        s1.psp = 99.00;

        //Problems:
        // 1. no validation checks before object creation.
        // Hence, object will be created and then validations will be performed.
        // 2. client can modify the public attributes and no validation checks will be present.

        //FIX 1:
        // Use parameterized constructors and put validation checks inside them and throw an exception if invalid parameter.
        // and make attributes private and use getters and setters.

    }
}
