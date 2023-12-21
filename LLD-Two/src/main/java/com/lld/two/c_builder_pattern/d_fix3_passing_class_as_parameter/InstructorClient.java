package com.lld.two.c_builder_pattern.d_fix3_passing_class_as_parameter;

import java.util.HashMap;
import java.util.Map;

public class InstructorClient {
    public static void main(String[] args) {
        //Scenario 1: Create a student object with name, psp, batch .
        //validations:
        // psp between [0,100]
        // batch follows some regex.

//        Student s0 = new Student();
//        s0.name= "Razat";
//        s0.batch = "intermediatefeb23";
//        s0.psp = 99.00;

        //Problems:
        // 1. no validation checks before object creation. (memory wastage)
        // Hence, object will be created and then validations will be performed.
        // 2. client can modify the public attributes and no validation checks will be present.

        //FIX 1:
        // Use parameterized constructors and put validation checks inside them and throw an exception if invalid parameter.
        // and make attributes private and use getters and setters.
        Student s1 = new Student("Razat",99.00,"intermediatefeb23");
        //cons:
        // now validation checks can be done before object creation.
        //####Problems with constructor approach:
        // 1. multiple combinations of parameters possible and hence, many constructors(2^n) needs to be created.
        // 2. calling constructors for client will be error prone due to strict order of parameters.
        //e.g., Student s2 = new Student("intermediatefeb23",99,"Rahul");
        // 3. not readable, need to add comments while calling constructor for mapping parameters with their names.
        // e.g., new Student(/*name=*/ "Razat", )

        //Fix 2:
        // store attributes and their values as key-value pairs in a map and pass it to constructor.
        //e.g., Map<String,Object> map   where key -> attribute name ,  value -> value of attribute.
        // new Student(Map<String,Object> map)
        Map<String,Object> hm = new HashMap<>();
        hm.put("name","Razat");
        hm.put("psp",99.0);
        hm.put("batch","intermediatefeb23");
        Student s2 = new Student(hm);

        //### PROS:
        // solved the issue of many constructors.
        //####Problem with single map object passed to constructor approach:
        //1. no type checking at compile time.
        //e.g., Map<String,Object> hm ,
        //hm.put("psp","xyz") will compile.
        //2. Client always need to take care of attribute names . Hence, prone to human errors like misspelling.

        //Fix 3:
        // store attributes and their values in a different class(act as placeholder) and pass it to constructor.
        StudentBuilder studentBuilder = new StudentBuilder();
        studentBuilder.setName("Razat");
        studentBuilder.setBatch("IntermediateFeb23");
        studentBuilder.setPsp(99.0);
        Student s3 = new Student(studentBuilder);
        System.out.println(s3);
        //PROS:
        //1. Type checking is fixed.
        //2. Readability is improved for client. Hence, not error-prone to misspellings etc.
        //3. No multiple constructors required for combination of attributes.
        //CONS:
        //1. Client is not aware about StudentBuilder object dependency.
        // Hence, Client needs to create StudentBuilder object first in order to create a Student object.




    }
}
