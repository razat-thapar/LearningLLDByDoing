package com.lld.two.d_prototype_registry_pattern.c_fixing_prototype_using_registry_pattern.game;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
//        //this tree_pixels will be created by some other API call/method call / etc..
//        //this is expensive.
//        List<Integer> tree_pixels = List.of(23,34,32,112,255,0);
//        //### Prototype Pattern
//
//        //Step 1: Create interface having clone() method.
//        //Step 2: Create concrete class implementing that interface and overriding clone()
//        //Step 3: Create a copy constructor to perform deep or shallow copies.
//        //Step 4: Client creates different prototype objects like tree,river,mountains.
//        //Step 5: Client can now create any no of clones of this prototype.
//        BackgroundObject tree_prototype = new BackgroundObject(0.0,0.0,0.0, BackgroundObjectType.TREE,tree_pixels);
//        //create 100 clones of tree object
//        List<BackgroundObject> trees = new ArrayList<>();
//        for(int i=0;i<100;i++){
//            trees.add(tree_prototype.clone());
//        }
//        System.out.println(trees.size());
//        //NOTE: Sometimes it's not easy to create deep copies of an object as we might not have access to the code of other dependencies.
//        // Hence, we can take help of external libraries.
//        // https://www.baeldung.com/java-deep-copy
//        //PROS:
//        //1. Requirement to create a lot of Tree objects in background is fullfilled with less effort.
//
//        //CONS:
//        //1. How will other method calls be able to reuse this prototype object and create clones outside this class. ?
//        //2. How we will manage different prototype objects ??

        // ## Prototype Pattern + Registry Pattern.
        //Step 1: Create interface having clone() method.
        //Step 2: Create concrete class implementing that interface and overriding clone()
        //Step 3: Create a copy constructor to perform deep or shallow copies.
        //Step 4: Client creates different prototype objects like tree,river,mountains.
        //Step 5: register these prototypes in a Registry.
        //Step 6: Client gets prototype object based on it's type from getRegistery(key) method.
        //Step 7: Client can now create any no of clones of any prototype.

        //this tree_pixels will be created by some other API call/method call / etc..
        //this is expensive.
        List<Integer> tree_pixels = List.of(23,34,32,112,255,0);

        // create a registry or inject it.
        Registry<BackgroundObjectType,BackgroundObject> bgPrototypeRegistry = new Registry<>();
        // create a prototype.
        BackgroundObject tree_prototype = new BackgroundObject(0.0,0.0,0.0, BackgroundObjectType.TREE,tree_pixels);
        //register.
        bgPrototypeRegistry.register(BackgroundObjectType.TREE,tree_prototype);
        //create copies.
        createTrees(bgPrototypeRegistry);
        //PROS:
        //All requirements related to creation of lot of objects and managing the prototypes are fullfilled.

        //CONS:
        //NONE>

    }
    public static void createTrees(Registry<BackgroundObjectType, BackgroundObject> registry){
        //fetch the prototype.
        BackgroundObject tree_prototype = registry.getRegistry(BackgroundObjectType.TREE);
        //create 100 clones of tree object
        List<BackgroundObject> trees = new ArrayList<>();
        for(int i=0;i<100;i++){
            trees.add(tree_prototype.clone());
        }
        System.out.println(trees.size());
    }
}
