package com.lld.two.c_builder_pattern.e_fix4_improving_fix3_usingBuilderpattern;

import java.util.Date;
import java.util.Map;

public class Student {
    private String name;
    private int age;
    private int gradYear;
    private String university;
    private Date dob;

    private double psp;
    private String batch;

    public static StudentBuilder getStudentBuilder(){
        return new StudentBuilder();
    }
    public Student(StudentBuilder studentBuilder){
        double psp;
        if(studentBuilder==null){
            throw new RuntimeException();
        }
        //validating name
        if(studentBuilder.getName() != null) {
            this.name = studentBuilder.getName();
        }
        //validating age
        //validating gradYear
        //validating university
        //validating psp
        if(studentBuilder.getPsp() != null) {
            psp = studentBuilder.getPsp();
            if (psp >= 0 && psp <= 100) {
                this.psp = psp;
            } else {
                throw new RuntimeException();
            }
        }
        //validating batch
        if(studentBuilder.getBatch() != null) {
            //check regex validation checks
            this.batch = studentBuilder.getBatch();
        }
    }
    //for any client.
    public Student(Map<String, Object> hm) {
        double psp;
        if(hm==null){
            throw new RuntimeException();
        }
        //validating name
        if(hm.get("name") != null) {
            this.name = (String) hm.get("name");  //explicit type casting.
        }
        //validating age
        //validating gradYear
        //validating university
        //validating psp
        if(hm.get("psp") != null) {
            psp = (double) hm.get("psp");//explicit type casting.
            if (psp >= 0 && psp <= 100) {
                this.psp = psp;
            } else {
                throw new RuntimeException();
            }
        }
        //validating batch
        if(hm.get("batch") != null) {
            //check regex validation checks
            this.batch = (String) hm.get("batch"); //explicit type casting.
        }
    }

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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gradYear=" + gradYear +
                ", university='" + university + '\'' +
                ", dob=" + dob +
                ", psp=" + psp +
                ", batch='" + batch + '\'' +
                '}';
    }
}
