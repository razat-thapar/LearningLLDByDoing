package com.lld.one.c_inheritance_polymorphism.subtype_polymorphism;

public class Circle implements Shape{
    private double radius;

    public Circle(double radius){
        this.radius=radius;
    }
    @Override
    public double getArea() {
        return (Math.PI*radius*radius)%(MOD);
    }

    @Override
    public double getPerimeter() {
        return (2*Math.PI*radius)%(MOD);
    }

    public void circleDetails(){
        System.out.printf("Circle with radius : %f %n",this.radius);
    }
}
