package com.lld.two.i_flyweight_pattern.c_fix_flyweight_registry_factorymethod_pattern;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        //PUBG GAME USING 400 BULLETS.
//        int count = 400;
//        List<Bullet> bullets = new ArrayList<>();
//        for(int i=0;i<count;i++) {
//            bullets.add(Bullet
//                    .builder()
//                    .x(12)
//                    .y(15)
//                    .z(3)
//                    .speed(432)
//                    .image("image")
//                    .bulletType(BulletType.CLOSE_RANGE)
//                    .damageFactor(32)
//                    .radius(5)
//                    .build());
//        }
//        double memoryGegaBytes = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/(1024*1024);
//        System.out.println(memoryGegaBytes);  //this returns total JVM memory usage.

        //PROBLEMS :
        //1. Not scalable. (if we create more instances of bullets , then memory usage is very high than expected).

        //FIX:
        //Flyweight Pattern.
        //steps:
        //1. store intrinsic state of object only in current class.
        //2. store extrinsic state of object in another class.
        //3. create a reference variable in extrinsic class to store shared reference of intrinsic object .

        //PROS:
        //1. it's scalable.(No more out of memory issues with 20,000 bullets.

        //CONS:
        //1. Bullet (intrinsic state) is created but we are not storing it for reuse.
        //2. Creation of bullet is tightly coupled with client code. (VIOLATION OF DEPENDENCY INVERSION)

        //FIX: Flyweight + Registry + Factory Method
        //since, intrinsic objects are shared , hence, we can also create a BulletRegistry to store these objects based on type. 
        //we can create Factory hierarchy to deal with creation of different bullets.
        //PUBG GAME USING 400 BULLETS.
        int count = 400;
        BulletRegistry bulletRegistry = new BulletRegistry();
        //get Rifle bullet.
        BulletFactory bulletFactory = new RifleBulletFactory();
        //create a rifle bullet and save to registry
        bulletRegistry.add(bulletFactory.createBullet());
        List<FlyingBullet> flyingBullets = new ArrayList<>();
        for(int i=0;i<count;i++) {
            flyingBullets.add(FlyingBullet
                    .builder()
                    .x(12)
                    .y(15)
                    .z(3)
                    .bullet(bulletRegistry.get(BulletType.RIFLE))
                    .speed(432)
                    .radius(5)
                    .build());
        }
        double memoryGegaBytes = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/(1024*1024);
        System.out.println(memoryGegaBytes);  //this returns total JVM memory usage.

        //PROBLEMS:
        //1.
    }
}
