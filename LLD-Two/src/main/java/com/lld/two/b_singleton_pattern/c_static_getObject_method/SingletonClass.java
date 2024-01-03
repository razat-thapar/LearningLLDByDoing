package com.lld.two.b_singleton_pattern.c_static_getObject_method;

public class SingletonClass {
    private String x;
    private static SingletonClass obj;
    private SingletonClass(){
        this.x = "singleton object";
    }
    public static SingletonClass getObject(){
        if(obj==null){
            obj = new SingletonClass();
            return obj;
        }
        return obj;
    }

    @Override
    public String toString() {
        return "SingletonClass : x = "+x;
    }
}
