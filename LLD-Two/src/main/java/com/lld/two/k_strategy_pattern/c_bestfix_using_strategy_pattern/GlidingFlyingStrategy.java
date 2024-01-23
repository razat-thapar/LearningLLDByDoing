package com.lld.two.k_strategy_pattern.c_bestfix_using_strategy_pattern;

public class GlidingFlyingStrategy implements FlyingStrategy{
    @Override
    public void fly() {
        System.out.println("Gliding...");
    }
}
