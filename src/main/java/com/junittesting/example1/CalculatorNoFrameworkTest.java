package com.junittesting.example1;

/*
 * This is a test class without a testing framework.
 * Drawbacks:
 * 1-It is outside of the test Maven layout.
 * 3-It is not bound to a build process.
 * 2-As an application gets more complicated and tests more
 * involved, continuing to build and maintain our own custom testing framework
 * becomes into chaos.
 */
public class CalculatorNoFrameworkTest {
    private int testErrors = 0;
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
            System.out.println("Test of Calculator=OK");
        }catch (Throwable e) {
            test.testErrors++;
            e.printStackTrace();
        }
        
        if (test.testErrors > 0) {
            throw new IllegalStateException("There were " + test.testErrors
            + " error(s)");
        }
    }
}
