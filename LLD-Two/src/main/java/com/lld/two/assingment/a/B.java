package com.lld.two.assingment.a;

public class B extends A{
    private static B instance = null; //holds only the object of B
    //singleton class B.using double check locking
    private B(){
        super();
    }
    public static B getInstance() throws RuntimeException{
        if(instance==null){
            synchronized(B.class){
                if(instance==null){
                    instance = new B();
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
