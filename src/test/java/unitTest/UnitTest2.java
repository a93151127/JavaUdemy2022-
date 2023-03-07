package unitTest;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

public class UnitTest2 {
    @Test
    void testFail() {
        fail("我設置為失敗");
    }
}
