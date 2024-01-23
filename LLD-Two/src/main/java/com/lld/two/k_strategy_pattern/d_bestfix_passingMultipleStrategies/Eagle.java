package com.lld.two.k_strategy_pattern.d_bestfix_passingMultipleStrategies;

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
        System.out.println("\nEagle: \n");
        flyingStrategy.fly();
    }
}
