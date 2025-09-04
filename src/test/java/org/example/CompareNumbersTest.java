package org.example;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
public class CompareNumbersTest {
    @Test
    public void testEqualNumbers(){
        assertEquals(CompareNumbers.compare(6,6),0);
    }
    @Test
    public void testFirstBig(){
        assertTrue(CompareNumbers.compare(10,6) >0);
    }
    @Test
    public void restSecondBig(){
        assertTrue(CompareNumbers.compare(1,6) <0 );
    }
}
