package com.lld.two.a_SOLID_principles.c_Liskov_substitution_principle.b_try_fixing_by_adding_flyableBird_class;

public class FlyableBird extends Bird{

    public FlyableBird(String name){
        super(name);
    }
    public void fly(){
        System.out.println("Bird is flying !");
    }

}
