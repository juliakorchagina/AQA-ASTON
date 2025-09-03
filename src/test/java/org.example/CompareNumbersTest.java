package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompareNumbersTest {
    @Test
    void testEqualNumbers() {
        assertEquals(0, CompareNumbers.compare(6, 6));
    }

    @Test
    void testFirstBig() {
        assertTrue(CompareNumbers.compare(10, 6) > 0);
    }

    @Test
    void testSecondBig() {
        assertTrue(CompareNumbers.compare(1, 6) < 0);
    }
}
