package com.lld.two.a_SOLID_principles.a_SRP.b_handling_different_bird_types;

public class Bird {
    //attributes of bird.
    String name,color;
    BirdType type;
    double windSpeed,height, weight;
    public Bird(BirdType type){
        this.type = type;
    }
    //behaviors.
    void fly(){
        if(type == BirdType.Sparrow){
            System.out.println("fly like sparrow");
        }else if(type == BirdType.Hen){
            System.out.println("fly like hen");
        }else if(type == BirdType.Eagle){
            System.out.println("fly like eagle");
        }else if(type == BirdType.Penguin){
            System.out.println("fly like penguin");
        }else{
            //in-valid type.
            throw new RuntimeException();
        }
    }
    void talk(){

    }
    void layEggs(){

    }
}
