package com.lld.one.b_access_modifier_constructor.demo_destructor;

public class Point {
    private double x;
    private double y;
    public Point(double x, double y){
        this.x=x;
        this.y=y;
    }
    @Override
    protected void finalize() throws Throwable{
        System.out.printf("Disconnect any resources before object being destroyed by GC. %n");
    }
}
