package com.lld.two.assingment.a.using_eager_initialization;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ABTest {
    @Test
    @Order(1)
    @Disabled
    public void testGetInstanceFirstCall() {
        A a = A.getInstance();
        B b = B.getInstance();
        assertNotNull(a);
        assertNotNull(b);
    }
    @Test
    @Order(1)
    public void testGetInstanceFirstCallReverse() {
        B b = B.getInstance();
        A a = A.getInstance();
        assertNotNull(b);
        assertNotNull(a);

    }

    @Test
    @Order(2)
    @Disabled
    public void testGetInstanceOtherCalls() {
        RuntimeException exceptionA = assertThrowsExactly(RuntimeException.class,()-> A.getInstance());
        RuntimeException exceptionB = assertThrowsExactly(RuntimeException.class,()-> B.getInstance());
        assertEquals(exceptionA.getMessage(), "2nd time object creation call not allowed!!");
        assertEquals(exceptionB.getMessage(), "2nd time object creation call not allowed!!");
    }


}
