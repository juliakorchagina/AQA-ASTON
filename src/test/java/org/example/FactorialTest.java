package org.example;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FactorialTest {
    @Test
    public void testFactorialOfZero() {
        assertEquals(Factorial.calculate(0), 1);
    }

    @Test
    public void testFactorialOfFive() {
        assertEquals(Factorial.calculate(5), 120);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNegativeNumberThrowsException() {
        Factorial.calculate(-1);
    }
}
