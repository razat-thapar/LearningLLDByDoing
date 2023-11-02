package com.lld.one.b_access_modifier_constructor.demo_constructors;

public class Rectangle {
    private Point topLeft;
    private Point bottomRight;
    //default constructor
    public Rectangle(){
        this.topLeft= null;
        this.bottomRight=null;
    }
    //parameterized
    public Rectangle(Point topLeft, Point bottomRight){
        this.topLeft = new Point(topLeft.x,topLeft.y);
        this.bottomRight = new Point(bottomRight.x, bottomRight.y);
    }
    //copy constructor
    public Rectangle(Rectangle other){
        this.topLeft= new Point(other.topLeft);
        this.bottomRight = new Point(other.bottomRight);
    }

    public double getArea(){
        double width = Math.abs(this.bottomRight.x - this.topLeft.x);
        double height = Math.abs(this.topLeft.y - this.bottomRight.y);
        return width*height;
    }

    public double getPerimeter(){
        double width = Math.abs(this.bottomRight.x - this.topLeft.x);
        double height = Math.abs(this.topLeft.y - this.bottomRight.y);
        return 2*(width+height);
    }
}
