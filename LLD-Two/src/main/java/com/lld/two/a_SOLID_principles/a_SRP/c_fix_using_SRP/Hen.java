package com.lld.two.a_SOLID_principles.a_SRP.c_fix_using_SRP;

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
    void talk() {
        System.out.println("talk like hen! cuckroo cuckroo");
    }
}
