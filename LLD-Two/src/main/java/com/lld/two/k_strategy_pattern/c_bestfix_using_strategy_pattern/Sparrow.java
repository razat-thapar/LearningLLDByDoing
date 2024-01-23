package com.lld.two.k_strategy_pattern.c_bestfix_using_strategy_pattern;

import java.util.ArrayList;
import java.util.List;

public class Sparrow extends Bird implements Flyable{
    //Step 3: create a reference variable to store dependency of type FlyingStrategy. i.e., Aggregation
    private FlyingStrategy flyingStrategy ;

    public Sparrow(String name, FlyingStrategy flyingStrategy){
        super(name);
        type = BirdType.Sparrow;
        this.flyingStrategy = flyingStrategy;
    }
    @Override
    public void fly(){
        //step 4: delegation
        flyingStrategy.fly();
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
