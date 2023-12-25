package com.lld.two.a_SOLID_principles.c_Liskov_substitution_principle.c_try_fixing_by_removing_fly_fromBird;

public class Sparrow extends Bird {

    public Sparrow(String name){
        super(name);
        type = BirdType.Sparrow;
    }
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
