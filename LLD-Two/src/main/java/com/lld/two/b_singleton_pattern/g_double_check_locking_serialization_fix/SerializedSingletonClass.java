package com.lld.two.b_singleton_pattern.g_double_check_locking_serialization_fix;

import java.io.Serial;
import java.io.Serializable;

public class SerializedSingletonClass implements Serializable {
    private static int count = 0;
    private static SerializedSingletonClass obj = null;
    private SerializedSingletonClass(){
        count++;
    }
    public static SerializedSingletonClass getObject(){
        if(obj==null){
            synchronized (SerializedSingletonClass.class){
                if(obj == null){
                    obj = new SerializedSingletonClass();
                    return obj;
                }
            }
        }
        return obj;
    }

    @Serial
    public Object readResolve(){
        return obj;
    }

    @Override
    public String toString() {
        return "SingletonClass : object count = "+count;
    }
}
