package com.junittesting.example1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test-suite A
 * 
 */
@RunWith(value = Suite.class)
@SuiteClasses(value={Dummy1Test.class,Dummy2Test.class})
public class TestSuiteA {}
