package com.lld.one.m_garbage_collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GCDemo {
    private int id;
    @Override
    public void finalize(){
        System.out.printf("GCDemo %d is collected successfully by GC!%n",id);
    }
}
