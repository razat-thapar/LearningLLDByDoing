package com.lld.two.assingment.a.using_eager_initialization;

public class B extends A {
    private static B instance = new B(); //holds only the object of B
    //singleton class B.using double check locking
    private B(){
        super();
    }
    public static B getInstance() throws RuntimeException{
        return instance;
    }
}
