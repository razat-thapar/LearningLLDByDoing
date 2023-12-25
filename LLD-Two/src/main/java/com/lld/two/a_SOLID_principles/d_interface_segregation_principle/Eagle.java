package com.lld.two.a_SOLID_principles.d_interface_segregation_principle;

public class Eagle extends Bird implements Flyable {
    public Eagle(String name){
        super(name);
        this.type = BirdType.Eagle;
    }

    @Override
    public void fly() {
        System.out.println("Fly like eagle");
    }
}
