package com.lld.two.b_singleton_pattern.d_mutex_on_whole_getObject_method;

public class SingletonClass {
    private static int count = 0;
    private static final String lock = "lock";
    private static SingletonClass obj;
    private SingletonClass(){
        count++;
    }
    public static SingletonClass getObject(){
        synchronized (lock) {
            if (obj == null) {
                obj = new SingletonClass();
                return obj;
            }
            return obj;
        }
    }

    @Override
    public String toString() {
        return "SingletonClass : object count = "+count;
    }
}
