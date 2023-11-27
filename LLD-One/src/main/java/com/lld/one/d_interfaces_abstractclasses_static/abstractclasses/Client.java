package com.lld.one.d_interfaces_abstractclasses_static.abstractclasses;

public class Client {
    public static void main(String[] args) {
        // scenario 1: Using Animal as a reference variable.
        //NOTE HERE: Only methods available in Animal_Interface are available.
        Animal platypus1 = new Platypus("platypus01");
        platypus1.run();
        platypus1.walk();

        // scenario 1: Using Mammals as a reference variable.
        //NOTE HERE: hatchTime() and layEggs() methods are not available
        Mammals platypus2 = new Platypus("platypus02");
        platypus2.run();
        platypus2.walk();
        platypus2.eat();
        platypus2.talk();
        platypus2.hunt();
        // scenario 3: Using Platypus as a reference variable.
        //HERE: Every method is available.
        Platypus platypus3 = new Platypus("platypus03");
        platypus3.eat();
        platypus3.hunt();
        platypus3.walk();
        System.out.printf("Hatch time for %s is %d days!%n",platypus3,platypus3.hatchTime());
        platypus3.laysEggs();
        platypus3.run();
        platypus3.talk();

    }
}
