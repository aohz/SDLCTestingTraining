package com.junittesting.example2;

import java.util.ArrayList;
import org.junit.Assert;

import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
public class UserManagerTest {
    
    /*
     * The mock can be created in two ways:
     * a) use of @Mock annotation. 
     * In this case use the MockitoJUnitRunner test runner.
     * b) Invoking the static method mock(), e.g. in the setup 
     * method of the JUnit framework test class.
     */
    @InjectMocks
    private UserManager userManager;
 
    @Mock
    private UserService userService;
    
//    @Before
//    public void setUp() throws Exception {
//        userService = Mockito.mock(UserService.class);
//        userManager = new UserManager();
//        userManager.setUserService(userService);
//    }
    
    @Test
    public void testSaveUser() throws Exception {
        User user = new User("u1");
        userManager.saveUser(user);
 
        //Verify if saveUser was invoked on userService with given 'user' object.
        Mockito.verify(userService).saveUser(user);

    }
    
    @Test
    public void testCountNumberOfInteractions() throws Exception {

        userManager.findUser("user1");

        //Verify the number of interactions with mock
        Mockito.verify(userService, Mockito.times(1)).findUserByName("user1");

        //There was only one interaction with userService
        Mockito.verifyNoMoreInteractions(userService);
    }
    
    
    @Test
    public void testFindUser() throws Exception {

        
    /* One of the basic functions of mocking frameworks is an ability to return
       a given value when a specific method is called. It can be done using
       Mockito.when() in conjunction with thenReturn (). This process of defining
       how a given mock method should behave is called stubbing. */
        
//      Stub the value that will returned on call to userService.findUserByName
        User stubbedUser = new User("userAfterSave");
        Mockito.when(userService.findUserByName("user1")).thenReturn(stubbedUser);

        //make the call
        User user = userManager.findUser("user1");

        //Verify if findUserByName method was invoked on userService call
        Mockito.verify(userService).findUserByName("user1");

        Assert.assertEquals("userAfterSave", user.getUserName());
    }
    
    @Test
    public void testStubArrayList() throws Exception {

        //Mock the Arraylist
        ArrayList mock = Mockito.mock(ArrayList.class);

        //Stub the values
        Mockito.when(mock.get(0)).thenReturn("value1");
        Mockito.when(mock.get(1)).thenReturn("value2");

        //Check the value at 0 & 1
        Assert.assertEquals("value1", mock.get(0));
        Assert.assertEquals("value2", mock.get(1));

    }
    
    @Test(expected = RuntimeException.class)
    public void testThrowException() throws Exception {

        //throw an exception on call to userService
        Mockito.doThrow(new RuntimeException()).when(userService).saveUser(Mockito.<User>any());

        //this will throw RunTime exception
        userManager.saveUser(Mockito.mock(User.class));

    }
    
}
