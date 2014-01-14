package com.junittesting.example1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test-suite B
 * 
 */
@RunWith(value = Suite.class)
@SuiteClasses(value={CalculatorBasicTest.class, CalculatorParameterizedTest.class})
public class TestSuiteB {}