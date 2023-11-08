package com.lld.one.c_inheritance_polymorphism.method_overriding;

public class Sparrow extends Bird{

    public void fly(){
        System.out.printf("%s is flying! %n",this);
    }

    public static void hunt(){
        System.out.printf("%s is hunting! %n",Sparrow.class.getSimpleName());
    }
}
