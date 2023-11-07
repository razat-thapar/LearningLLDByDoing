package com.lld.one.c_inheritance_polymorphism.inheritance_demo;

import java.util.ArrayList;
import java.util.List;

public class Instructor extends User{
    List<String> batches;
    double avg_rating;

    public Instructor(String name, int id, String username){
        super(name,id,username);
        this.batches = new ArrayList<>();
    }
    public void printUsername(){
        //super.username is not allowed due to private access modifier.
        //System.out.printf("Username is %s %n",super.username);
        System.out.printf("Username is %s %n",super.getUsername());
    }
    public void printDetails(){
        System.out.printf("id : %d %n name : %s %n username : %s %n",super.id,super.name,super.getUsername());
        System.out.printf("Batches under me : %n");
        for(String batch : batches){
            System.out.println(batch);
        }
    }

    public void scheduleClass() {
        System.out.println(this.name + " is scheduling class! ");
    }
    public void addBatch(String batchName){
        batches.add(batchName);
    }
}
