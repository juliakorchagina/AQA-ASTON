package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleAreaTest {
    @Test
    void testValidTriangle() {
        assertEquals(6.0, TriangleArea.calculate(3, 4, 5), 0.001);
    }

    @Test
    void testInvalidTriangle() {
        assertThrows(IllegalArgumentException.class, () -> TriangleArea.calculate(1, 2, 10));
    }
}
