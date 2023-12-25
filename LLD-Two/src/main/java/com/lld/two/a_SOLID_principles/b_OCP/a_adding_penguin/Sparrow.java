package com.lld.two.a_SOLID_principles.b_OCP.a_adding_penguin;

public class Sparrow extends Bird{

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
