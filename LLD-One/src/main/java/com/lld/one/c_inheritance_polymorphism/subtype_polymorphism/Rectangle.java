package com.lld.one.c_inheritance_polymorphism.subtype_polymorphism;

public class Rectangle implements Shape{
    private double width;
    private double height;
    public Rectangle(double w, double h){
        this.width=w;
        this.height=h;
    }
    @Override
    public double getArea(){
        return (width*height)%MOD;
    }

    @Override
    public double getPerimeter() {
        return (2*(width+height))%MOD;
    }

    public void rectangleDetails(){
        System.out.printf("Rectangle with width : %f & height : %f %n",this.width,this.height);
    }
}
