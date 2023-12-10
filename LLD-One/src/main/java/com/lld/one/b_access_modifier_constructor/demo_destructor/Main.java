package com.lld.one.b_access_modifier_constructor.demo_destructor;

public class Main{
    public static void main(String[] args) {
        //Java performs destroying of unreachable objects out of the box.
        //Hence, no destructors required.
        //Scenario 1: Calling garbage collection and overriding finalize method.
        Point p = new Point(2.1,3.5);
        System.out.println("Point p Object address: "+p);
        //make object unreachable, so that java can do garbage collection.
        p=null;

        //scenario 2: Using AutoCloseable interface to close any resources before destruction by GC.
        try{
        Point2 p2 = new Point2(32, 23);
        System.out.println("Point p2 Object address: "+p2);
        p2=null;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
