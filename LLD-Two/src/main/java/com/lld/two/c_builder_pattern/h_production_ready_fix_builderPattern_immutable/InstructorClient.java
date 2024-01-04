package com.lld.two.c_builder_pattern.h_production_ready_fix_builderPattern_immutable;

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
        //Student s1 = new Student("Razat",99.00,"intermediatefeb23");

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
        //Student s2 = new Student(hm);

        //### PROS:
        // solved the issue of many constructors.
        //####Problem with single map object passed to constructor approach:
        //1. no type checking at compile time.
        //e.g., Map<String,Object> hm ,
        //hm.put("psp","xyz") will compile.
        //2. Client always need to take care of attribute names . Hence, prone to human errors like misspelling.

        //Fix 3:
        // store attributes and their values in a different class(act as placeholder) and pass it to constructor.
//        StudentBuilder studentBuilder = new StudentBuilder();
//        studentBuilder.setName("Razat");
//        studentBuilder.setBatch("IntermediateFeb23");
//        studentBuilder.setPsp(99.0);
//        Student s3 = new Student(studentBuilder);

        //PROS:
        //1. Type checking is fixed.
        //2. Readability is improved for client. Hence, not error-prone to misspellings etc.
        //3. No multiple constructors required for combination of attributes.
        //CONS:
        //1. Client is not aware about StudentBuilder object dependency.
        // Hence, Client needs to create StudentBuilder object first in order to create a Student object.

        //Fix 4:
        //To improve fix 3 further, we can.
            //1. provide a static method in Student class that returns a new StudentBuilder object to the client.
            //   why static ?
            //   Client can access the method without any object.
    //        StudentBuilder studentBuilder1 = Student.getStudentBuilder();
    //        studentBuilder1.setName("Razat");
    //        studentBuilder1.setBatch("IntermediateFeb23");
    //        studentBuilder1.setPsp(99.0);
    //        Student s4 = new Student(studentBuilder1);
    //        System.out.println(s4);

            //CONS:
            //Now, still, client can create studentBuilder object via StudentBuilder constructor, how to restrict that?
            //   Make StudentBuilder constructor private but Student class won't be able to access it .

        //Fix 5: Builder Pattern Part 1.
        //Earlier, StudentBuilder was only responsible to hold the attributes so that client can pass it to Student() constructor.
        //We will do the following :
        //1. We will give following responsibilities to StudentBuilder class.
        //      a. act as a placeholder for Student attributes.
        //      b. once client calls build() method on StudentBuilder object , create a new Student object and return it to client.
        //2. We will give following responsibilities to Student class.
        //      a. It will make the constructor private so that client will create object via StudentBuilder only.
        //      b. For Immutable Student object,
        //          all attributes can be made private so that client can't modify them once initialized.
        //          All setters methods can be made private as well so that client can't modify the attributes once set.
        //Due to private Student constructor, now we can't access it in StudentBuilder class.
        //Easy fix is to make StudentBuilder class as inner class of Student.
        //3. Now to do something like below i.e., method chaining:
        //   StudentBuilder studentBuilder = Student.getStudentBuilder()
        //                                 .setName("Razat")
        //                                 .setBatch("IntermediateFeb23")
        //                                 .setPsp(99.0)
        //                                 .build();
        //   We will do the following :
        //      a.  We will make setter methods of StudentBuilder class return implicit reference. i.e., "this"
        //          e.g.,  public StudentBuilder setName(String name){
        //                      this.name = name;
        //                      return this;
        //                 }
        //Now, this is called Builder design pattern.

            //PROS:

            // 1. On-Demand Initialization.
            // 2. Complex Validations ( a set of attributes can be validated together.)
            // 3. Immutability ( can be achieved easily by removing setter methods from Student)
            // 4. Type checking of attributes of Builder class can be done at compile time ( compared to Map<String,Object>).
            // 5. Clients can easily build Student Objects like below as Builder class have the responsibility to build Student object.
                    //CASE 1 : Mutable Objects of Student.
//                    Student s = Student.getStudentBuilder()
//                            .setName("Razat")
//                            .setBatch("Intermediate")
//                            .setPsp(99.0)
//                            .build();
//                    System.out.println(s);
//                    //can modify attributes here.
//                    s.setAge(27);
//                    System.out.println(s);

                    //Case 2: Immutable Object of Student.

            //CONS:
            // 1. Not Easily Extensible (OCP principle is violated ).
            //  WHY ?  Duplication of Fields in Builder Class.
            //   e.g., Prone to error while adding new fields say boolean isActive
            //         in Student class which might miss adding in Builder class.

        // FIX 6 : Instead of copying the fields in Builder class, do following:
        //         a. Make an object of Student student = new Student();
        //         b. Use this as a placeholder to pass all attributes from client via setter methods.
        //         c. in build() method, create a new student by copying the fields from student object.
        //         d. Here, we can also provide complex validation checks in build() method only instead of Student constructor.
            //PROS:

            // 1. On-Demand Initialization.
            // 2. Complex Validations ( a set of attributes can be validated together.)
            // 3. Immutability ( can be achieved easily by removing setter methods from Student)
            // 4. Type checking of attributes of Builder class can be done at compile time ( compared to Map<String,Object>).
            // 5. Clients can easily build Student Objects like below as Builder class have the responsibility to build Student object.
            // 6. No Duplication of fields . Hence, it's easily extensible.
            //CASE 1 : Mutable Objects of Student.


            //Case 2: Immutable Object of Student.
            Student s = Student.getStudentBuilder()
                    .setName("Razat")
                    .setBatch("Intermediate")
                    .setPsp(99.0)
                    .build();
            System.out.println(s);
            //can't modify attributes here.
            //s.setAge(27); throws error.
            System.out.println(s);





    }
}
