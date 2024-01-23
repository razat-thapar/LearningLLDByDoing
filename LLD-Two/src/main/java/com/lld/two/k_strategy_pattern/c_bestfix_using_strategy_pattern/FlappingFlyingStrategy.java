package com.lld.two.k_strategy_pattern.c_bestfix_using_strategy_pattern;

public class FlappingFlyingStrategy implements FlyingStrategy{

    @Override
    public void fly() {
        System.out.println("Flapping. it's wings....");
    }
}
