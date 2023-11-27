package com.lld.one.d_interfaces_abstractclasses_static.abstractclasses;

public class Platypus extends Mammals implements LaysEggs{
    public Platypus(String name){
        super(name);
    }
    @Override
    public void eat() {
        System.out.printf("%s is eating!%n",this.name);
    }

    @Override
    public void talk() {
        System.out.printf("%s is talking!%n",this.name);
    }

    @Override
    public void hunt() {
        System.out.printf("%s is hunting!%n",this.name);
    }

    @Override
    public void laysEggs() {
        System.out.printf("%s is laying eggs!%n",this.name);
    }

    @Override
    public int hatchTime() {
        return 32;
    }

    @Override
    public void run() {
        System.out.printf("%s is running!%n",this.name);
    }

    @Override
    public void walk() {
        System.out.printf("%s is walking!%n",this.name);
    }
}
