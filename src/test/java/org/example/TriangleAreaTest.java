package org.example;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TriangleAreaTest {
    @Test
    public void testValidTriangle() {
        assertEquals(TriangleArea.calculate(3, 4, 5), 6.0, 0.001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidTriangle() {
        TriangleArea.calculate(1, 2, 10);
    }
}
