
package com.arquilliantesting.example1;

import java.io.PrintStream;

/**
 * A component for creating personal greetings.
 * 
 * We want to verify that this class behaves properly when invoked as a CDI bean. 
 * Of course, we could simply write a unit test. But let’s pretend that the bean 
 * uses enterprise services such as dependency injection and messaging and must 
 * be used inside a container. (Besides, that way we give it room to grow ~;))
 * To use the class as a CDI bean, we’ll be injecting it into the test using the 
 * @Inject annotation. That calls for an Arquillian test! That means it’s time 
 * to add the Arquillian API to the project!
 */
public class Greeter {
    public void greet(PrintStream to, String name) {
        to.println(createGreeting(name));
    }

    public String createGreeting(String name) {
        return "Hello, " + name + "!";
    }
}
