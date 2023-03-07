package unitTest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UnitTestTest1 {

    static UnitTest ut = null;
    @BeforeAll
    public static void beforeEveryTest(){
        ut = new UnitTest();
    }

    @AfterAll
    public static void afterEveryTest(){
        System.out.println("hello junit");
    }
    @Test
    void add() {
        System.out.println("add:" + ut.hashCode());
        assertEquals(2, ut.add(1, 1));
    }

    @Test
    void sub() {
        System.out.println("sub:" + ut.hashCode());
        assertEquals(0, ut.sub(1, 1));
    }
}