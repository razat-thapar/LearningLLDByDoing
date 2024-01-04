package com.lld.two.d_prototype_registry_pattern.c_fixing_prototype_using_registry_pattern.game;
import java.util.HashMap;
import java.util.Map;
public class Registry<K,V> {
    private Map<K,V> registry = new HashMap<>();
    public V getRegistry(K key){
        return registry.get(key);
    }
    public void register(K key, V value){
        registry.put(key,value);
    }
}
