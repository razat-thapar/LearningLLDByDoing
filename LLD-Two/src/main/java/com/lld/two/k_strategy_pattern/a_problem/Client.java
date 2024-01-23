package com.lld.two.k_strategy_pattern.a_problem;

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

    }
}
