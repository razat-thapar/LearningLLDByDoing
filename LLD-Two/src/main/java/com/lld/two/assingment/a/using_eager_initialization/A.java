package com.lld.two.assingment.a.using_eager_initialization;

public class A {
    private static boolean child,parent;
    private static A instance = new A();//holds only the object of A
    //singleton class A.using eager initialization.
    protected A(){
        if(this instanceof B && !child) {
            //mark it as one call made for creating child object.
            child = true;
        }else if(this instanceof A && !parent){
            parent = true;
        }else{
            throw new RuntimeException("2nd time object creation call not allowed!!");
        }
    }
    public static A getInstance() throws RuntimeException{
        return instance;
    }
}
