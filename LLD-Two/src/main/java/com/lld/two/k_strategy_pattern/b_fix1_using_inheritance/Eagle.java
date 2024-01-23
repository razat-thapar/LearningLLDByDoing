package com.lld.two.k_strategy_pattern.b_fix1_using_inheritance;

public class Eagle extends Bird implements Flyable {
    public Eagle(String name){
        super(name);
        this.type = BirdType.Eagle;
    }

    @Override
    public void fly() {
        System.out.println("Gliding...");
    }
}
