package com.lld.two.b_singleton_pattern.b_getObject_method;

public class SingletonClass {
    private String x;
    private SingletonClass obj;
    private SingletonClass(){

    }
    public SingletonClass getObject(){
        if(this.obj==null){
            this.obj = new SingletonClass();
            return this.obj;
        }
        return this.obj;
    }
}
