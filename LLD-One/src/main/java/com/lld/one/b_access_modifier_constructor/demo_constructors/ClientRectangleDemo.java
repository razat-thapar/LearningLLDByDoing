package com.lld.one.b_access_modifier_constructor.demo_constructors;

public class ClientRectangleDemo {
    public static void main(String[] args) {
        //scenario 1: Create a new Rectangle
        Point topleft1 = new Point(2,3);
        Point bottomRight1 = new Point(4,9);
        Rectangle r1 = new Rectangle(topleft1,bottomRight1);
        System.out.printf("Object Address: "+r1+",\n Area: %f,\n Perimeter: %f \n",r1.getArea(),r1.getPerimeter());
        //scenario 2: Create a copy of r1 using copy constructor.
        Rectangle copy = new Rectangle(r1);
        System.out.printf("Object Address: "+copy+",\n Area: %f,\n Perimeter: %f \n",copy.getArea(),copy.getPerimeter());
    }
}
