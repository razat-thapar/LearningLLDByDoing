package com.lld.two.b_singleton_pattern.f_eager_initilization;

public class SingletonClass {
    private static int count = 0;
    private static SingletonClass obj = new SingletonClass();
    private SingletonClass(){
        count++;
    }
    public static SingletonClass getObject(){
        return obj;
    }

    @Override
    public String toString() {
        return "SingletonClass : object count = "+count;
    }
}
