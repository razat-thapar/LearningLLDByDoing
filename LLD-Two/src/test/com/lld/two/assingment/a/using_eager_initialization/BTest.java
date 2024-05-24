package com.lld.two.assingment.a.using_eager_initialization;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BTest {

    @Test
    @Order(1)
    void getInstanceFirstCall() {
        B instance = B.getInstance();
        assertNotNull(instance);
    }

    @Test
    @Order(2)
    @Disabled
    void getInstanceOtherCalls() {
        RuntimeException runtimeException = assertThrowsExactly(RuntimeException.class, () -> B.getInstance());
        assertEquals(runtimeException.getMessage(),"2nd time object creation call not allowed!!");
    }
}