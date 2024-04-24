package com.lld.one.o_java10_add_ons.a_var_keyword;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println(getStringVarValue());
        System.out.println(getIntegerVarValue());
        System.out.println(getListVarValue());
        System.out.println(getMapVarValue());
    }
    public static String getStringVarValue(){
        var value = "This is a demo of local variable type inference!";
        return value;
    }
    public static Integer getIntegerVarValue(){
        var value = 12;
        return value;
    }
    public static List<Integer> getListVarValue(){
        var list = List.of(12,13);
        return list;
    }
    public static Map<Character,Integer> getMapVarValue(){
        var map = Map.of('a',0,'b',1);
        return map;
    }
}
