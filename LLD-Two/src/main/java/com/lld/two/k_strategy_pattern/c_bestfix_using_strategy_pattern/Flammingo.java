package com.lld.two.k_strategy_pattern.c_bestfix_using_strategy_pattern;

public class Flammingo extends Bird implements Flyable {
    //Step 3: create a reference variable to store dependency of type FlyingStrategy. i.e., Aggregation
    private FlyingStrategy flyingStrategy;

    public Flammingo(String name, FlyingStrategy flyingStrategy){
        super(name);
        type = BirdType.Flammingo;
        this.flyingStrategy = flyingStrategy;
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
        //step 4: delegation.
        flyingStrategy.fly();
    }
}
