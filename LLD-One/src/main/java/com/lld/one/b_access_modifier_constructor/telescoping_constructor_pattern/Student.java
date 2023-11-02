package com.lld.one.b_access_modifier_constructor.telescoping_constructor_pattern;

public class Student {
    private int rollNo; //mandatory
    private String firstName; //mandatory
    private String lastName; //optional
    private char gender; //mandatory
    private double age; //optional

    public Student(int rollNo,String firstName, char gender){
        this(rollNo,firstName,gender,0);
    }
    public Student(int rollNo,String firstName, char gender,double age){
        this(rollNo,firstName,null,gender,age);
    }
    public Student(int rollNo,String firstName,String lastName, char gender,double age){
        this.rollNo=rollNo;
        this.firstName=firstName;
        this.lastName=lastName;
        this.gender=gender;
        this.age=age;
    }
}
