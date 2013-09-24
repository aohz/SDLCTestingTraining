
package com.junittesting.example1;

import static org.junit.Assert.*;
import org.junit.Test;


/* 
 * 1
 * Define test class.
 * It must be public.
 */
public class CalculatorBasicTest {
    
/* 
 * 2
 * Mark the test method.
 */
   @Test
    public void testAdd() {
        /*
         * 3
         * Instance the object under test.
         */
        Calculator calculator = new Calculator();
        /*
         * 4
         * Call the method to test by passing it known values.
         */
        double result = calculator.add(10, 50);
        /*
         * 5
         * To check the result of the test, we call
         * an assertEquals method (see imported classes).
         * The params:
         * @expected = 60
         * @actual = result
         * @delta = 0
         * You can run the test now!
         */
        assertEquals(60, result, 0);
    }
}
