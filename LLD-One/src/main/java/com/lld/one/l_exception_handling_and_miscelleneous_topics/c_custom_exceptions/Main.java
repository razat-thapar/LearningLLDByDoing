package com.lld.one.l_exception_handling_and_miscelleneous_topics.c_custom_exceptions;

public class Main {
    public static void main(String[] args){

        for(int i=0;i<=5;i++) {
            System.out.printf("num : %d , inverse : %f%n", i, demoFunction(i));
        }


    }
    public static Double demoFunction(double x){
        //prints inverse of x.
        try {
            if(x==0){
                throw new DemoException("division by zero is not allowed!");
            }
            return 1/x;
        } catch (DemoException e) {
            System.out.printf("DemoException occurred : %s%n",e.getStackTrace());
            return null;
        }
    }
}
