package com.lld.two.assingment.a;

public class A {
    private static A instance = null;//holds only the object of A
    private static boolean child = true , parent = true;
    //singleton class A.using eager initialization.
    protected A(){
        if(this instanceof B && child) {
            System.out.println(this instanceof B);
            //mark it as one call made for creating child object.
            child = false;
        }else if(this instanceof A && parent){
            System.out.println(this instanceof A);
            parent = false;
        }else{
            throw new RuntimeException("2nd time object creation call not allowed!!");
        }
    }
    public static A getInstance() throws RuntimeException{
        if(instance==null){
            synchronized(A.class){
                if(instance==null){
                    instance = new A();
                }else{
                    throw new RuntimeException("2nd time object creation call not allowed!!");
                }
            }
        }else{
            throw new RuntimeException("2nd time object creation call not allowed!!");
        }
        return instance;
    }
}
