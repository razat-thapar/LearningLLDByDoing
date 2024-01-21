package com.lld.two.i_flyweight_pattern.c_fix_flyweight_registry_factorymethod_pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class Bullet {
    private int damageFactor;
    private BulletType bulletType;
    private String image;
}
