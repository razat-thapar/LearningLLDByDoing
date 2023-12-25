package com.lld.two.a_SOLID_principles.c_Liskov_substitution_principle.d_best_fix_by_creating_flyable_interface;

public class Eagle extends Bird implements Flyable{
    public Eagle(String name){
        super(name);
        this.type = BirdType.Eagle;
    }

    @Override
    public void fly() {
        System.out.println("Fly like eagle");
    }
}
