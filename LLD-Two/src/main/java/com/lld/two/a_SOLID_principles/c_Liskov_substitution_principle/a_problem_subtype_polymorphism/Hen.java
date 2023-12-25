package com.lld.two.a_SOLID_principles.c_Liskov_substitution_principle.a_problem_subtype_polymorphism;

public class Hen extends Bird {
    public Hen(String name){
        super(name);
        type = BirdType.Hen;
    }

    @Override
    public void fly(){
        throw new RuntimeException("Hen don't fly");
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
