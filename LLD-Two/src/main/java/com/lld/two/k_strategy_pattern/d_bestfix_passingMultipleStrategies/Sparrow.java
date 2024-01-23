package com.lld.two.k_strategy_pattern.d_bestfix_passingMultipleStrategies;

import java.util.List;

public class Sparrow extends Bird implements Flyable {
    //Step 3: create a reference variable to store dependency of type FlyingStrategy. i.e., Aggregation
    private List<FlyingStrategy> flyingStrategies ;

    public Sparrow(String name, List<FlyingStrategy> flyingStrategies){
        super(name);
        type = BirdType.Sparrow;
        this.flyingStrategies = flyingStrategies;
    }
    @Override
    public void fly(){
        //step 4: delegation
        System.out.println("\nSparrow: \n");
        flyingStrategies.forEach(FlyingStrategy::fly);
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
