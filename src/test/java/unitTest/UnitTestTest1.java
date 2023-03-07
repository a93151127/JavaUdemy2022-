package unitTest;

import org.junit.Ignore;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTestTest1 {

    static UnitTest ut = null;
    @BeforeAll
    public static void beforeEveryTest(){
        ut = new UnitTest();
    }

    @AfterAll
    public static void afterEveryTest(){
        System.out.println("hello junit");
    }
    //@Ignore //這個是JUnit4的用法
    @Disabled //這個是JUnit5的用法
    @Test
    public void add() {
        System.out.println("add:" + ut.hashCode());
        assertEquals(2, ut.add(1, 1));
    }

    @Test
    public void sub() {
        System.out.println("sub:" + ut.hashCode());
        assertEquals(0, ut.sub(1, 1));
    }

    @Test
    public void testException() {
        Exception exception = assertThrows(ArithmeticException.class, ()->{
            int r = 1/0;
        });
    }

    @Test
    @Timeout(value = 2000)
    public void testTimeOut() {
        //設置執行續超過1000millis,大於Timeout的value,因此預期會拋錯
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}