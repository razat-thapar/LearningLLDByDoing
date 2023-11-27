package com.lld.one.d_interfaces_abstractclasses_static.static_keyword;

public class Math {
    //symbolic constants
    public static final double PI = 22/7;
    //methods.
    public static double getFloor(double x){
        return x - x%1 ;
    }
    public static double getCeil(double x){
        double ans = (x - x%1);
        if(x%1 != 0){
            ans = ans + 1;
        }
        return ans;
    }
    //inner class
    public static class NestedMaths{
        public static void display(){
            System.out.println("This is a static nested class");
        }
    }

}
