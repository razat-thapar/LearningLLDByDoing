package com.lld.two.i_flyweight_pattern.c_fix_flyweight_registry_factorymethod_pattern;

import java.util.HashMap;
import java.util.Map;

public class BulletRegistry {
    private Map<BulletType,Bullet> map;
    public BulletRegistry(){
        map = new HashMap<>();
    }
    public void add(Bullet bullet){
        map.putIfAbsent(bullet.getBulletType(),bullet);
    }
    public Bullet get(BulletType bulletType){
        return map.get(bulletType);
    }
    public void remove(BulletType bulletType){
        map.remove(bulletType);
    }
}
