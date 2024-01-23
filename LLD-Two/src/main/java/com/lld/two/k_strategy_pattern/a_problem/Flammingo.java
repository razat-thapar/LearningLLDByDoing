package com.lld.two.k_strategy_pattern.a_problem;

public class Flammingo extends Bird{

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
}
