package com.lld.two.c_builder_pattern.f_fix5_builderPattern_mutable;

import java.util.Date;

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
    private Student(StudentBuilder studentBuilder){
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

    public static class StudentBuilder {
        private String name;
        private Integer age;
        private Integer gradYear;
        private String university;
        private Date dob;
        private Double psp;
        private String batch;

        public Student build(){
            return new Student(this);
        }

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder setAge(Integer age) {
            this.age = age;
            return this;
        }

        public StudentBuilder setGradYear(Integer gradYear) {
            this.gradYear = gradYear;
            return this;
        }

        public StudentBuilder setUniversity(String university) {
            this.university = university;
            return this;
        }

        public StudentBuilder setDob(Date dob) {
            this.dob = dob;
            return this;
        }

        public StudentBuilder setPsp(Double psp) {
            this.psp = psp;
            return this;
        }

        public StudentBuilder setBatch(String batch) {
            this.batch = batch;
            return this;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Integer getGradYear() {
            return gradYear;
        }

        public String getUniversity() {
            return university;
        }

        public Date getDob() {
            return dob;
        }

        public Double getPsp() {
            return psp;
        }

        public String getBatch() {
            return batch;
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getGradYear() {
        return gradYear;
    }

    public String getUniversity() {
        return university;
    }

    public Date getDob() {
        return dob;
    }

    public double getPsp() {
        return psp;
    }

    public String getBatch() {
        return batch;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGradYear(int gradYear) {
        this.gradYear = gradYear;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setPsp(double psp) {
        this.psp = psp;
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
