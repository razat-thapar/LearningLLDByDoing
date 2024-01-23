package com.lld.two.k_strategy_pattern.b_fix1_using_inheritance;

public class Sparrow extends Bird implements Flyable{

    public Sparrow(String name){
        super(name);
        type = BirdType.Sparrow;
    }
    @Override
    public void fly(){
        System.out.println("Gliding...");
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
