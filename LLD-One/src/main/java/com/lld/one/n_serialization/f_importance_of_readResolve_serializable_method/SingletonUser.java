package com.lld.one.n_serialization.f_importance_of_readResolve_serializable_method;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
@Getter
@Setter
@ToString
public class SingletonUser implements Serializable {
    //singletonUser
    private static final long serialVersionUID = 1000L;
    private static SingletonUser instance = null;
    private SingletonUser(){}
    @ToString.Include
    private static String species = "HUMAN";
    private int id;
    private String name;
    private String email;
    private transient String password;

    @Serial
    private Object readResolve(){
        return instance;
    }
    public static SingletonUser getInstance(){
        if(instance == null){
            synchronized (SingletonUser.class){
                if(instance == null){
                    instance = new SingletonUser();
                    return instance;
                }
            }
        }
        return instance;
    }
}
