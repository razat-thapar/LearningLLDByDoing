package com.lld.two.i_flyweight_pattern.a_problem;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        //PUBG GAME USING 400 BULLETS.
        int count = 400;
        List<Bullet> bullets = new ArrayList<>();
        for(int i=0;i<count;i++) {
            bullets.add(Bullet
                    .builder()
                    .x(12)
                    .y(15)
                    .z(3)
                    .speed(432)
                    .image("image")
                    .bulletType(BulletType.CLOSE_RANGE)
                    .damageFactor(32)
                    .radius(5)
                    .build());
        }
        double memoryGegaBytes = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/(1024*1024);
        System.out.println(memoryGegaBytes);  //this returns total JVM memory usage.

        //PROBLEMS :
        //1. Not scalable. (if we create more instances of bullets , then memory usage is very high than expected).

        //FIX:
        //Flyweight Pattern.
    }
}
