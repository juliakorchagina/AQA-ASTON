package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {
        @Test
        void testFactorialOfZero() {
            assertEquals(1, Factorial.calculate(0));
        }
        @Test
        void testFactorialOfFive(){
            assertEquals(120, Factorial.calculate(5));
        }
        @Test
        void testNegativeNumberThrowsException(){
            assertThrows(IllegalArgumentException.class, () -> Factorial.calculate(-1));
        }
    }

