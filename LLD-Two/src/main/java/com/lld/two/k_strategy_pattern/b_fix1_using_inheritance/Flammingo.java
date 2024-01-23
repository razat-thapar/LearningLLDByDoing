package com.lld.two.k_strategy_pattern.b_fix1_using_inheritance;

public class Flammingo extends Bird implements Flyable{

    public Flammingo(String name){
        super(name);
        type = BirdType.Flammingo;
    }

    @Override
    public void layEggs() {
        System.out.println("lay eggs like flammingo");
    }

    @Override
    public void talk() {
        System.out.println("Talk like flammingo : honking honking");
    }

    @Override
    public void fly() {
        System.out.println("flapping it's wings");
    }
}
