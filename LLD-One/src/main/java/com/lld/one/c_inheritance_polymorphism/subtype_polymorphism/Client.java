package com.lld.one.c_inheritance_polymorphism.subtype_polymorphism;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        //subtyping
        // reference variable shapes is holding a list of different objects types but have common parent.
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(5));
        shapes.add(new Rectangle(3,4));
        for(Shape shape : shapes) {
            System.out.printf("Shape %n Type: %s %n Area: %f %n Perimeter: %f %n", shape.getClass().getSimpleName(), shape.getArea(), shape.getPerimeter());
        }
    }
}
