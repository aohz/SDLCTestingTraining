package com.arquilliantesting.example1;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * The @RunWith annotation tells JUnit to use Arquillian as the test controller. 
 * 
 * @author root
 */
@RunWith(Arquillian.class)
public class GreeterTest {

    @Inject
    Greeter greeter;
    /**
     * Arquillian looks for a public static method annotated with the @Deployment 
     * annotation to retrieve the test archive (i.e., micro-deployment).
     * Using ShrinkWrap, we’ve defined a Java archive (jar) as the deployment. 
     * It includes the Greeter class that the test will invoke and an empty beans.xml 
     * in the META-INF directory to activate CDI in this archive.
     * 
     * @return JavaArchive
     */
    @Deployment
    public static JavaArchive createDeployment() {
        /*return ShrinkWrap.create(JavaArchive.class)
            .addClass(Greeter.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");*/
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
            .addClass(Greeter.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        System.out.println(jar.toString(true));
        return jar;
    }

    /**
     * Some magic happens and each @Test method is run inside the container environment.
     * 
     */
    @Test
    public void should_create_greeting() {
        Assert.assertEquals("Hello, Earthling!",
            greeter.createGreeting("Earthling"));
        greeter.greet(System.out, "Earthling");
    }
}
