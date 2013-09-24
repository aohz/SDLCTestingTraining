package com.junittesting.example1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * This test-suite calls two other test-suites.
 * 
 */
@RunWith(value = Suite.class)
@SuiteClasses(value = { TestSuiteA.class, TestSuiteB.class })
public class MasterTestSuite {}