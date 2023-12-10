package com.lld.one.b_access_modifier_constructor.demo_destructor;

public class Point2 implements AutoCloseable{
    private double x;
    private double y;
    public Point2(double x, double y){
        this.x=x;
        this.y=y;
    }

    @Override
    public void close() throws Exception {
        System.out.println("close() method is called to close resources of an object before destruction.");
    }
}
