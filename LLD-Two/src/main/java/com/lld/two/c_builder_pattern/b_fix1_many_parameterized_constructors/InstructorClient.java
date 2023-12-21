package com.lld.two.c_builder_pattern.b_fix1_many_parameterized_constructors;

public class InstructorClient {
    public static void main(String[] args) {
        //Scenario 1: Create a student object with name, psp, batch .
        //validations:
        // psp between [0,100]
        // batch follows some regex.
        Student s1 = new Student("Razat",99.00,"intermediatefeb23");

        //Problems:
        // 1. no validation checks before object creation. (memory wastage)
        // Hence, object will be created and then validations will be performed.
        // 2. client can modify the public attributes and no validation checks will be present.

        //FIX 1:
        // Use parameterized constructors and put validation checks inside them and throw an exception if invalid parameter.
        // and make attributes private and use getters and setters.
        //cons:
        // now validation checks can be done before object creation.
        //Problems with constructor approach:
        // 1. multiple combinations of parameters possible and hence, many constructors(2^n) needs to be created.
        // 2. calling constructors for client will be error prone due to strict order of parameters.
        //e.g., Student s2 = new Student("intermediatefeb23",99,"Rahul");
        // 3. not readable, need to add comments while calling constructor for mapping parameters with their names.
        // e.g., new Student(/*name=*/ "Razat", )

        //Fix 2:
        // store attributes and their values as key-value pairs in a map and pass it to constructor.
        //e.g., Map<String,Object> map   where key -> attribute name ,  value -> value of attribute.
        // new Student(Map<String,Object> map)

    }
}
