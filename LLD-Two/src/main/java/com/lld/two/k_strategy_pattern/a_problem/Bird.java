package com.lld.two.k_strategy_pattern.a_problem;


public class Bird {
    //attributes of bird.
    protected String name,color;
    protected BirdType type;
    double windSpeed,height, weight;
    public Bird(String name){
        this.name = name;
    }
    //behaviors.
    void fly(){
        switch(type){
            case Sparrow : System.out.println("gliding...");
            break;
            case Hen : System.out.println("fly like hen");
            break;
            case Eagle : System.out.println("gliding...");
            break;
            case Flammingo: System.out.println("flapping it's wings");
            break;
            default: throw new RuntimeException();
        }
    }
    public void talk(){
        System.out.printf("%s is talking%n",this.type);
    }
    public void layEggs(){
        System.out.printf("%s is laying eggs%n",this.type);
    }
}
