package com.lld.one.d_interfaces_abstractclasses_static.abstractclasses;

public abstract class Mammals extends Animal{
    public Mammals(String name){
        super(name);
    }
    public abstract void eat();
    public abstract void talk();
    public abstract void hunt();
}
