package com.lld.two.a_SOLID_principles.c_Liskov_substitution_principle.a_problem_subtype_polymorphism;


public class Bird {
    //attributes of bird.
    String name,color;
    BirdType type;
    double windSpeed,height, weight;
    public Bird(String name){
        this.name = name;
    }
    public void fly(){
        System.out.printf("%s is flying%n",this.type);
    }
    //behaviors.
    public void talk(){
        System.out.printf("%s is talking%n",this.type);
    }
    public void layEggs(){
        System.out.printf("%s is laying eggs%n",this.type);
    }
}
