package com.lld.two.i_flyweight_pattern.c_fix_flyweight_registry_factorymethod_pattern;

public class RifleBulletFactory implements BulletFactory{

    @Override
    public Bullet createBullet() {
        return Bullet
                .builder()
                .image("rifle bullet image")
                .bulletType(BulletType.RIFLE)
                .damageFactor(100)
                .build();
    }
}
