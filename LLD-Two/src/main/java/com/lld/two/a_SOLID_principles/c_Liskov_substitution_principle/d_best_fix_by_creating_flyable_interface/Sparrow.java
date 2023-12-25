package com.lld.two.a_SOLID_principles.c_Liskov_substitution_principle.d_best_fix_by_creating_flyable_interface;

public class Sparrow extends Bird implements Flyable , Danceable{

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

    @Override
    public void dance() {
        System.out.println("Dance like a sparrow");
    }
}
