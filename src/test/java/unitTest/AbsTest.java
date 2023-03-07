package unitTest;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AbsTest {


    @DisplayName("Test with @MethodSource")
    @ParameterizedTest(name = "{index}: (|{0}|) => {1})")
    @MethodSource("localParameters")
    public void test(int first, int second) {
        int r = Math.abs(first);
        assertEquals(second, r);
    }

    public static Stream<Arguments> localParameters() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(-1, 1)
        );
    }
}
