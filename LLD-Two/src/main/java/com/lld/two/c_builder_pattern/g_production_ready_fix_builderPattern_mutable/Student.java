package com.lld.two.c_builder_pattern.g_production_ready_fix_builderPattern_mutable;

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
    private Student(){

    }
    public static class StudentBuilder {

        //instead of copying the fields of Student, we will create a student object.
        private final Student student = new Student();

        public StudentBuilder setName(String name) {
            student.name = name;
            return this;
        }

        public StudentBuilder setAge(Integer age) {
            student.age = age;
            return this;
        }

        public StudentBuilder setGradYear(Integer gradYear) {
            student.gradYear = gradYear;
            return this;
        }

        public StudentBuilder setUniversity(String university) {
            student.university = university;
            return this;
        }

        public StudentBuilder setDob(Date dob) {
            student.dob = dob;
            return this;
        }

        public StudentBuilder setPsp(Double psp) {
            student.psp = psp;
            return this;
        }

        public StudentBuilder setBatch(String batch) {
            student.batch = batch;
            return this;
        }

        public Student build(){
            Student newStudent = new Student();
            //perform complex validations here !
            //validating name
            if(student.name != null) {
                newStudent.name = student.name;
            }
            //validating psp
            if (student.psp >= 0 && student.psp <= 100) {
                newStudent.psp = student.psp;
            } else {
                throw new RuntimeException();
            }
            //validating batch
            if(student.batch != null) {
                //check regex validation checks
                newStudent.batch = student.batch;
            }
            //validating age
            //validating gradYear
            //validating university
            newStudent.age = student.age;
            newStudent.dob = student.dob;
            newStudent.gradYear = student.gradYear;
            newStudent.university = student.university;
            return newStudent;
        }
        //getters for Builder class.
        public String getName() {
            return student.name;
        }

        public Integer getAge() {
            return student.age;
        }

        public Integer getGradYear() {
            return student.gradYear;
        }

        public String getUniversity() {
            return student.university;
        }

        public Date getDob() {
            return student.dob;
        }

        public Double getPsp() {
            return student.psp;
        }

        public String getBatch() {
            return student.batch;
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

    //Setters methods (can be removed in case of immutable object. )

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
