package com.lld.one.c_inheritance_polymorphism.restricting_inheritance.using_private_constructor;

public class Parent {
    //make all the constructors of a Parent as private and use builder pattern.
    private int id;
    private Parent(){
        System.out.println("Parent's default constructor is invoked!!");
    }
    public Parent(int id){
        this.id = id;
    }
}
