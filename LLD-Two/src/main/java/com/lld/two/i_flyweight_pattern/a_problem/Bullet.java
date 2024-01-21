package com.lld.two.i_flyweight_pattern.a_problem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class Bullet {
    private double x;
    private double y;
    private double z;
    private double radius;
    private double direction;
    private double speed;
    private int damageFactor;
    private BulletType bulletType;
    private String image;
}
