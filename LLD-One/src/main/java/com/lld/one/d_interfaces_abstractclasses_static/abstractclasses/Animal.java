package com.lld.one.d_interfaces_abstractclasses_static.abstractclasses;

public abstract class Animal {
    protected String name;
    public Animal(String name){
        this.name=name;
    }

    public Animal() {

    }

    public abstract void run();
    public abstract void walk();
    public void sayHello(){
        System.out.printf("%s says hello",this.name);
    }
}
