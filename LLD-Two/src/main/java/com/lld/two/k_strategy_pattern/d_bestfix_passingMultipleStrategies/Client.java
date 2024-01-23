package com.lld.two.k_strategy_pattern.d_bestfix_passingMultipleStrategies;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        //Scenario :  We need to implement different flying behaviors for a Bird depending on type of bird.
        //e.g., Sparrow --> flyies by gliding
        //e.g., Eagle   --> flyies by gliding.
        //e.g., Hen     --> don't fly

        //approach 1: if else based implementation of fly() method
        //PROS:
        //1. it's a bruteforce way and works but have poor design
        //CONS:
        //1. SRP is violated ( fly() method have multiple reasons to change.) .
        //2. OCP is violated ( if we add a new Bird , then we need to modify fly() method in Bird Class )
        //3. Liskov's substitution is violated ( Hen subclass is throwing an exception while others won't since, Hen can't fly).

        //approach 2: Abstract out common behaviors from all subclasses and create an interface for each behavior so to adhere to Interface segregation.
        //e.g., flyable , danceable, walkable etc....
        //PROS:
        //1. SRP is not violated.
        //2. OCP is not violated.
        //3. Liskov's substitution is not violated.
        //4. Interface Segregation.
        //CONS:
        //1. Code Duplication.
        // what if Sparrow and Eagle share same flying behavior e.g.., gliding.
        // this will lead to copying the implementation in different subclasses .
        // hence, duplication of code which can further lead to inconsistencies.

        //best approach: Strategy Pattern.
        //Steps:
        //1. Strategy Interface.
        //2. Concrete Strategy subclasses.
        //3. Context class.
        //   Context class has-a Strategy
        //   we need to create a reference variable of Strategy Interface in Context class.
        ///  we also need to use dependency injection to inject Strategy for loose coupling with Strategy subclasses.
        //4. delegation.
        //  we need to delegate the behavior to Strategy interface.
//        Sparrow sparrow = new Sparrow("Twitty",new GlidingFlyingStrategy());
//        Eagle eagle = new Eagle("sharp", new GlidingFlyingStrategy());
//        Hen hen = new Hen("Roster");
//        Flammingo flammingo = new Flammingo("pinky",new FlappingFlyingStrategy());
//
//
//        List<Flyable> flyingBirds = List.of(sparrow,eagle,flammingo);
//        //flying each bird from the above list.
//        flyingBirds.forEach(Flyable::fly);

        //PROS:
        //1. No code duplication issues and also SOLID principles are respected.
        //CONS:
        //1. What if a sparrow can show both gliding , flapping strategies.
        // easy fix :  Sparrow should have  List<FlyingStrategy> strategyList instead of one. 
        Sparrow sparrow = new Sparrow("Twitty",List.of(new GlidingFlyingStrategy(),new FlappingFlyingStrategy()));
        Eagle eagle = new Eagle("sharp", new GlidingFlyingStrategy());
        Hen hen = new Hen("Roster");
        Flammingo flammingo = new Flammingo("pinky",new FlappingFlyingStrategy());

        List<Flyable> flyingBirds = List.of(sparrow,eagle,flammingo);
        //flying each bird from the above list.
        flyingBirds.forEach(Flyable::fly);


    }
}
