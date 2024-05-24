package com.lld.two.assingment.a.using_eager_initialization;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ATest {

    @Test
    @Order(1)
    void getInstanceFirstCall() {
        A instance = A.getInstance();
        assertNotNull(instance);
    }

    @Test
    @Order(2)
    void getInstanceOtherCallUsingConstructor() {
        RuntimeException runtimeException = assertThrowsExactly(RuntimeException.class, () -> new A());
        assertEquals(runtimeException.getMessage(),"2nd time object creation call not allowed!!");
    }

    @Test
    @Order(3)
    @Disabled
    void getInstanceOtherCalls() {
        RuntimeException runtimeException = assertThrowsExactly(RuntimeException.class, () -> A.getInstance());
        assertEquals(runtimeException.getMessage(),"2nd time object creation call not allowed!!");
    }
}