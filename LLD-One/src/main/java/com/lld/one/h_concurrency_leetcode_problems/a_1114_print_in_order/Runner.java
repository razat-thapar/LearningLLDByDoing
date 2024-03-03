package com.lld.one.h_concurrency_leetcode_problems.a_1114_print_in_order;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        //create an instance of Foo and then spawn new threads based on given sequence.
        Foo foo = new Foo();
        List<Integer> nums = List.of(2,1,3);
        foo.printInOrder(nums);
    }
}
