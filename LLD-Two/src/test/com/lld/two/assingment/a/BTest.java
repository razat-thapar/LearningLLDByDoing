package com.lld.two.assingment.a;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

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
    void getInstanceOtherCalls() {
        RuntimeException runtimeException = assertThrowsExactly(RuntimeException.class, () -> B.getInstance());
        assertEquals(runtimeException.getMessage(),"2nd time object creation call not allowed!!");
    }
}