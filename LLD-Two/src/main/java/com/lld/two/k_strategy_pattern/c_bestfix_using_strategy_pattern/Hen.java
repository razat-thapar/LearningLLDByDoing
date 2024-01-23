package com.lld.two.k_strategy_pattern.c_bestfix_using_strategy_pattern;

public class Hen extends Bird {
    public Hen(String name){
        super(name);
        type = BirdType.Hen;
    }
    @Override
    public void layEggs(){
        System.out.println("lay eggs like hen!");
    }

    @Override
    public void talk() {
        System.out.println("talk like hen! cuckroo cuckroo");
    }
}
