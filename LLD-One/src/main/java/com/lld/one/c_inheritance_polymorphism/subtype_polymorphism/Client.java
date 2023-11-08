package com.lld.one.c_inheritance_polymorphism.subtype_polymorphism;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        //Scenario 1: Storing all types of objects using parent class i.e., Up-casting Circle object to Shape.
        // reference variable shapes is holding a list of different objects types but have common parent.
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(5));
        shapes.add(new Rectangle(3,4));
        for(Shape shape : shapes) {
            System.out.printf("Shape %n Type: %s %n Area: %f %n Perimeter: %f %n", shape.getClass().getSimpleName(), shape.getArea(), shape.getPerimeter());
        }

        //Scenario 2: Abstraction using subtyping.
        //Circle have special method : circleDetails()
        //Rectangle have special method : rectangleDetails()
        //Shape reference variable won't be able to access them.
        Shape s1 = new Circle(3.23);
        /*
        s1.circleDetails(); //won't work
         */
        //post down-casting to Circle it will work!
        Circle s2 = (Circle)s1;
        s2.circleDetails();

        //Scenario 3: creating parent's object & storing it in child reference variable.
        /* This will give compile time error. It's not possible to store parent's object in child class.
        Rectangle s3 = (Rectangle) new Shape(){

            @Override
            public double getArea() {
                return 0;
            }

            @Override
            public double getPerimeter() {
                return 0;
            }
        };
        */
    }
}
