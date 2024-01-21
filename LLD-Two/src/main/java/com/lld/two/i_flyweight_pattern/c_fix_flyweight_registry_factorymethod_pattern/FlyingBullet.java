package com.lld.two.i_flyweight_pattern.c_fix_flyweight_registry_factorymethod_pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class FlyingBullet {
    private double x;
    private double y;
    private double z;
    private double radius;
    private double direction;
    private double speed;
    //step 3: store an instance of intrinsic state of object in reference variable.
    private Bullet bullet;
}
