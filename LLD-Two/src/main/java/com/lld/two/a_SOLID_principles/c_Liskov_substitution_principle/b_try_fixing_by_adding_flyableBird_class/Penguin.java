package com.lld.two.a_SOLID_principles.c_Liskov_substitution_principle.b_try_fixing_by_adding_flyableBird_class;

public class Penguin extends Bird {

    public Penguin(String name){
        super(name);
        type = BirdType.Penguin;
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
