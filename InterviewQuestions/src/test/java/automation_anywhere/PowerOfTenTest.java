package automation_anywhere;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerOfTenTest {
    private static PowerOfTen p;
    @BeforeAll
    static void setUp() {
        p = new PowerOfTen();
    }
    @Test
    public void testIsPowerOfTenUsingPositiveInput(){
        assertEquals(true,p.isPowerOfTen(10));
        assertEquals(false,p.isPowerOfTen(5));
        assertEquals(true,p.isPowerOfTen(1));
    }
}