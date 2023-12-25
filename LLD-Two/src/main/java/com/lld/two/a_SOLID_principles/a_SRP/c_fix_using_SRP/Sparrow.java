package com.lld.two.a_SOLID_principles.a_SRP.c_fix_using_SRP;

public class Sparrow extends Bird {

    public Sparrow(String name){
        super(name);
        type = BirdType.Sparrow;
    }

    void fly(){
        System.out.println("fly like sparrow");
    }

    @Override
    void layEggs() {
        System.out.println("lay eggs like sparrow");
    }

    @Override
    void talk() {
        System.out.println("Talk like sparrow : chirp chirp");
    }
}
