package com.lld.one.c_inheritance_polymorphism.inheritance_demo;

public class User {
    String name;
    protected int id;
    private String username;

    public User(String name, int id, String username) {
        this.name=name;
        this.id=id;
        this.username=username;
    }

    void login(){
        System.out.println(name + " logging in !");
    }

    public String getUsername(){
        return this.username;
    }
}
