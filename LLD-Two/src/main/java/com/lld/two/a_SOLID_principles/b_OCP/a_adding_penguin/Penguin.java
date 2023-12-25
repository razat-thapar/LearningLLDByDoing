package com.lld.two.a_SOLID_principles.b_OCP.a_adding_penguin;

public class Penguin extends Bird{

    public Penguin(String name){
        super(name);
        type = BirdType.Penguin;
    }

    @Override
    public void fly() {
        throw new RuntimeException("Penguins don't fly");
    }

    @Override
    public void talk() {
        System.out.printf("%s is talking like penguin%n",this.name);
    }

    @Override
    public void layEggs() {
        System.out.printf("%s is laying eggs like penguin %n",this.name);
    }
}
