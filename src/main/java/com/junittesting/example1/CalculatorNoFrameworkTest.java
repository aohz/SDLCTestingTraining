package com.junittesting.example1;

/*
 * No JUnit test class.
 * It is outside of the test Maven layout.
 * As an application gets more complicated and tests more
 * involved, continuing to build and maintain our own custom testing framework
 * becomes into chaos.
 */
public class CalculatorNoFrameworkTest {
    private int nbErrors = 0;
    public void testAdd() {
        Calculator calculator = new Calculator();
        double result = calculator.add(10, 50);
        if (result != 60) {
            throw new IllegalStateException("Bad result: " + result);
        }
    }
    
    public static void main(String[] args) {
        CalculatorNoFrameworkTest test = new CalculatorNoFrameworkTest();
        try {
            test.testAdd();
        }catch (Throwable e) {
            test.nbErrors++;
            e.printStackTrace();
        }
        
        if (test.nbErrors > 0) {
            throw new IllegalStateException("There were " + test.nbErrors
            + " error(s)");
        }
    }
}
