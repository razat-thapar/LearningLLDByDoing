package com.lld.two.b_singleton_pattern.e_double_check_locking_mechanism;

public class SingletonClass {
    private static int count = 0;
    private static final String lock = "lock";
    private static volatile SingletonClass obj;
    // since, this variable is shared by multiple threads, hence, to ensure all threads have same value once a thread updates it. , we will use volatile keyword.
    private SingletonClass(){
        count++;
    }
    public static SingletonClass getObject(){
        if(obj == null) {
            synchronized (lock) {
                if (obj == null) {
                    obj = new SingletonClass();
                    return obj;
                }
                return obj;
            }
        }
        return obj;
    }

    @Override
    public String toString() {
        return "SingletonClass : object count = "+count;
    }
}
