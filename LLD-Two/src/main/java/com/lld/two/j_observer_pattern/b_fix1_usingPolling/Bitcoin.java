package com.lld.two.j_observer_pattern.b_fix1_usingPolling;

import lombok.Getter;

@Getter
public class Bitcoin {
    private double price ;
    private static Bitcoin instance ;
    private Bitcoin(){

    }
    public void setPrice(double price){
        this.price = price;
    }
    public static Bitcoin getInstance(){
        //double check locking mechanism.
        if(instance == null){
            synchronized (Bitcoin.class){
                if(instance == null){
                    instance = new Bitcoin();
                    return instance;
                }
            }
        }
        return instance;
    }
}
