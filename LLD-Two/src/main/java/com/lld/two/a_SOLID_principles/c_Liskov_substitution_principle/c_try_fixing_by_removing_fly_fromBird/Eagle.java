package com.lld.two.a_SOLID_principles.c_Liskov_substitution_principle.c_try_fixing_by_removing_fly_fromBird;

public class Eagle extends Bird{
    public Eagle(String name){
        super(name);
        this.type = BirdType.Eagle;
    }

}
