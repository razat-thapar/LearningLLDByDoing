package com.lld.two.a_SOLID_principles.a_SRP.c_fix_using_SRP;


public class Bird {
    //attributes of bird.
    String name,color;
    BirdType type;
    double windSpeed,height, weight;
    public Bird(String name){
        this.name = name;
    }
    //behaviors.
    void talk(){
        System.out.printf("%s is talking%n",this.type);
    }
    void layEggs(){
        System.out.printf("%s is laying eggs%n",this.type);
    }
}
