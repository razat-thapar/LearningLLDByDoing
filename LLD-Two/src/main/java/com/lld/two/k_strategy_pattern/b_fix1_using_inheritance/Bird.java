package com.lld.two.k_strategy_pattern.b_fix1_using_inheritance;


public class Bird {
    //attributes of bird.
    String name,color;
    BirdType type;
    double windSpeed,height, weight;
    public Bird(String name){
        this.name = name;
    }
    //behaviors.
    public void talk(){
        System.out.printf("%s is talking%n",this.type);
    }
    public void layEggs(){
        System.out.printf("%s is laying eggs%n",this.type);
    }
}
