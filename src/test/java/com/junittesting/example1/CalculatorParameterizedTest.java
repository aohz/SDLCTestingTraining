package com.junittesting.example1;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/*
 * 1
 * The test runner..
 * Remember:
 * 
 * org.junit.internal.runners.JUnit38ClassRunner 
 * Only for backward compatibility.
 * 
 * org.junit.runners.JUnit4 
 * This runner will start the test case as a JUnit 4 test case.
 * 
 * org.junit.runners.Parameterized 
 * A Parameterized test runner.
 * 
 * org.junit.runners.Suite
 * A container that can hold different tests.
 */
@RunWith(value=Parameterized.class)
public class CalculatorParameterizedTest {
    
    
    /*
     * 2
     * Declare instance variables used in the tests
     */
    private double expected;
    private double valueOne;
    private double valueTwo;
    
    /*
     * 3
     * Include a method to provide Parameters.
     * Parameters can be provided from static properties files. This allows 
     * adapt sets of parameters for our tests.
     * The signature of this method must be:
     * @Parameters 
     * public static java.util.Collection, NO parameters.
     */
    @Parameters
    public static Collection<Integer[]> getTestParameters() {
        return Arrays.asList(new Integer[][] {
            {2, 1, 1}, //expected, valueOne, valueTwo
            {3, 2, 1}, //expected, valueOne, valueTwo
            {4, 3, 1}, //expected, valueOne, valueTwo
        });
    }
    
    /*
     * 4
     * Because we want to test the add method of our Calculator program, 
     * we provide three parameters: expected value and two values that we add together
     */
    public CalculatorParameterizedTest(double expected, double valueOne, double valueTwo) {
        this.expected = expected;
        this.valueOne = valueOne;
        this.valueTwo = valueTwo;
    }
    
    /*
     * 5
     * Implement the sum @Test method, which instantiates the Calculator program.
     * Run the test!
     */
    @Test
    public void sum() {
        Calculator calc = new Calculator();
        assertEquals(expected, calc.add(valueOne, valueTwo), 0);
        
    }
}