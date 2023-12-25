package com.lld.two.a_SOLID_principles.c_Liskov_substitution_principle.a_problem_subtype_polymorphism;

public class NonFlyableException extends RuntimeException{
    public NonFlyableException(String message){
        super(message);
    }
    public NonFlyableException(){
        super();
    }
}
