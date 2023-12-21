package com.lld.two.c_builder_pattern.b_fix1_many_parameterized_constructors;

import java.util.Date;

public class Student {
    private String name;
    private int age;
    private int gradYear;
    private String university;
    private Date dob;

    private double psp;
    private String batch;
    //for instructor clients.
    public Student(String name, double psp , String batch){
        if(name != null){
            this.name = name;
        }else{
            throw new RuntimeException();
        }
        if(psp>=0 && psp <=100){
            this.psp = psp;
        }else{
            throw new RuntimeException();
        }
        //check regex validation check.
        this.batch = batch;
    }

    //for sales clients.
    public Student(String name,int age, int gradYear , String university){
        if(name != null){
            this.name = name;
        }else{
            throw new RuntimeException();
        }
        if(age<30){
            this.age = age;
        }else{
            throw new RuntimeException();
        }
        if(gradYear<2023){
            this.gradYear = gradYear;
        }else{
            throw new RuntimeException();
        }
        if(university != null){
            this.university = university;
        }else{
            throw new RuntimeException();
        }

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGradYear() {
        return gradYear;
    }

    public void setGradYear(int gradYear) {
        this.gradYear = gradYear;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public double getPsp() {
        return psp;
    }

    public void setPsp(double psp) {
        this.psp = psp;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }
}
