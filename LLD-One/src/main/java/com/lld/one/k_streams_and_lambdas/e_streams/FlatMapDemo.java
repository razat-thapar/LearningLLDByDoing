package com.lld.one.k_streams_and_lambdas.e_streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapDemo {
    public static void main(String[] args) {
        //stream api
        //use case: We got data from different sources and we want to merge these lists.
        List<Integer> integerList1 = Arrays.asList(1,2,3);
        List<Integer> integerList2 = Arrays.asList(4,5,6);
        List<Integer> integerList3 = Arrays.asList(7,8,9);

        List<List<Integer>> integerLists = Arrays.asList(integerList1,integerList2,integerList3);
        //The below won't work.
        //List<Integer> mergedList = integerLists.stream().map(x->x+x).collect(Collectors.toList());
        List<Integer> mergedList = integerLists.stream().flatMap(l->l.stream()).collect(Collectors.toList());
        System.out.println(mergedList);

    }
}
