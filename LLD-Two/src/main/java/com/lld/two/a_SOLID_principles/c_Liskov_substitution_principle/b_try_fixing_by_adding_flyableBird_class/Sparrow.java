package com.lld.two.a_SOLID_principles.c_Liskov_substitution_principle.b_try_fixing_by_adding_flyableBird_class;

public class Sparrow extends FlyableBird {

    public Sparrow(String name){
        super(name);
        type = BirdType.Sparrow;
    }
    @Override
    public void fly(){
        System.out.println("fly like sparrow");
    }

    @Override
    public void layEggs() {
        System.out.println("lay eggs like sparrow");
    }

    @Override
    public void talk() {
        System.out.println("Talk like sparrow : chirp chirp");
    }
}
