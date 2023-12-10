package com.lld.one.j_collections.a_iterator;

import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,3,234,32);
        //Scenario 1: Iterating using iterator.
        Iterator<Integer> iterator = numbers.iterator();
        while(iterator.hasNext()){
            System.out.printf("%d ,",iterator.next());
        }
        System.out.println();

        //Scenario 2: Iterating using enhanced for loop.
        for(Integer num : numbers){
            System.out.printf("%d ,",num);
        }

    }
}
