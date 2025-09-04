package org.example;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void testAddition() {
        assertEquals(Calculator.add(4, 2), 6);
    }

    @Test
    public void testSubtraction() {
        assertEquals(Calculator.subtract(3, 2), 1);
    }

    @Test
    public void testMultiplication() {
        assertEquals(Calculator.multiply(2, 3), 6);
    }

    @Test
    public void testDivision() {
        assertEquals(Calculator.divide(36, 6), 6);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero() {
        Calculator.divide(6, 0);

    }
}
