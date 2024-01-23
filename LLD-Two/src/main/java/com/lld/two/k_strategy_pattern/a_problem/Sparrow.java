package com.lld.two.k_strategy_pattern.a_problem;

public class Sparrow extends Bird{

    public Sparrow(String name){
        super(name);
        type = BirdType.Sparrow;
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
