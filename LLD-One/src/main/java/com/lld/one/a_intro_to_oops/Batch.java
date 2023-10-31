package com.lld.one.a_intro_to_oops;

public class Batch {
    private String name;
    private String instructorName;

    public Batch(String name, String instructorName) {
        this.name=name;
        this.instructorName=instructorName;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "name='" + name + '\'' +
                ", instructorName='" + instructorName + '\'' +
                '}';
    }

    public void addStudent(){
        System.out.printf("adding a student to %s",this.name);
    }

    public void changeInstructor(String name){
        this.instructorName=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }
}
