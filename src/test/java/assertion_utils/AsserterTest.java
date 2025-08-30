package assertion_utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsserterTest {

    @Test
    void hasText() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Asserter.Arg.hasText("  ", "testArg");
        });
        assertEquals("Argument 'testArg' must have text.", exception.getMessage());

        assertDoesNotThrow(() -> {
            Asserter.Arg.hasText("valid text", "testArg");
        });
    }

    @Test
    void isTrue() {
        int maxLength = 5;
        String val = "abcdef";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Asserter.Arg.isTrue(val.length() <= maxLength, "String must be at most %d chars, got: %s", maxLength, val);
        });
        assertEquals("String must be at most 5 chars, got: abcdef", exception.getMessage());

        assertDoesNotThrow(() -> {
            Asserter.Arg.isTrue(val.length() <= 10, "String must be at most %d chars, got: %s", 10, val);
        });
    }
}