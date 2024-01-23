package com.lld.two.k_strategy_pattern.d_bestfix_passingMultipleStrategies;

public class FlappingFlyingStrategy implements FlyingStrategy {

    @Override
    public void fly() {
        System.out.println("Flapping. it's wings....");
    }
}
