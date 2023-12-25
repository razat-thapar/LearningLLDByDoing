package com.lld.two.a_SOLID_principles.c_Liskov_substitution_principle.c_try_fixing_by_removing_fly_fromBird;


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
