package com.lld.two.k_strategy_pattern.d_bestfix_passingMultipleStrategies;

public class GlidingFlyingStrategy implements FlyingStrategy {
    @Override
    public void fly() {
        System.out.println("Gliding...");
    }
}
