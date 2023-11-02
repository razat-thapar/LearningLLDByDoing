package com.lld.one.b_access_modifier_constructor.demo_constructors;

public class Point {
    protected double x;
    protected double y;
    //default constructor.
    public Point(){
        this.x=0;
        this.y=0;
    }
    //parameterized constructor.
    public Point(double x, double y){
        this.x=x;
        this.y=y;
    }
    //copy constructor.
    public Point(Point other){
        this.x = other.x;
        this.y = other.y;
    }
}
