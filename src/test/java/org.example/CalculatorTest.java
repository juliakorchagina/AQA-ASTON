package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    @Test
    void testAddition() {
        assertEquals(6, Calculator.add(4, 2));
    }

    @Test
    void testSubtraction() {
        assertEquals(5, Calculator.subtract(6, 1));
    }

    @Test
    void testDivision() {
        assertEquals(6.0, Calculator.multiply(2, 3));
    }

    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> Calculator.divide(6, 0));
    }
}
