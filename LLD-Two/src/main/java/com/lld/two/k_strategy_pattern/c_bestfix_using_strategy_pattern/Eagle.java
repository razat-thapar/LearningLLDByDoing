package com.lld.two.k_strategy_pattern.c_bestfix_using_strategy_pattern;

public class Eagle extends Bird implements Flyable {
    //Step 3: create a reference variable to store dependency of type FlyingStrategy. i.e., Aggregation
    private FlyingStrategy flyingStrategy ;
    public Eagle(String name, FlyingStrategy flyingStrategy){
        super(name);
        this.type = BirdType.Eagle;
        this.flyingStrategy = flyingStrategy;
    }

    @Override
    public void fly() {
        //step 4: delegation.
        flyingStrategy.fly();
    }
}
