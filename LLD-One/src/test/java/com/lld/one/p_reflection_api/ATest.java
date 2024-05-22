package com.lld.one.p_reflection_api;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class ATest {
    @Test
    public void testSum() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //getting the class instance.
        Class c = Class.forName("com.lld.one.p_reflection_api.A");
        //creating an object of A
        A a = (A)c.getDeclaredConstructor(null).newInstance(null);
        //getting the method
        Method m = c.getDeclaredMethod("sum",int.class,int.class);
        //making it visible as it's private.
        m.setAccessible(true);
        //invoking it.
        int result = (int)m.invoke(a,1,2);
        assertEquals(3,result);
    }
}