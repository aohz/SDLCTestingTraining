package com.junittesting.example2;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

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
 
        //Verify with Argument Matcher
        Mockito.verify(userService).saveUser(Mockito.<user>any());
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
    public void testZeroInteractionsWithMock() throws Exception {

        User user = new User("user1", new Date());

        //call method where no call to userService will be made
        userManager.getUserLastLogin(user);
        Mockito.verifyZeroInteractions(userService);

        //Another way to check zero interactions
        userManager.getUserLastLogin(user);
        Mockito.verify(userService, Mockito.never());
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
    
    @Test
    public void testStubAndAnswer() throws Exception {
 
        //when method is invoked on mock, do some processing before return the stubbed object
 
        Mockito.when(userService.findUserByName(Mockito.anyString())).then(new Answer<user>() {
 
            public User answer(InvocationOnMock invocation) throws Throwable {
 
                //check argument passed to method if its not null
                //then give me time of day and make me a coffee before you return
                //you get the point, you can do anything here before returning
 
                Assert.assertNotNull(invocation.getArguments()[0]);
 
                return new User("UserCreatedByCallback");
            }
        });
 
        User user = userManager.findUser("user1");
 
        Assert.assertEquals("UserCreatedByCallback", user.getUserName());
 
 
        //Another way of answering the call
        Mockito.doAnswer(new Answer() {
 
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
 
                return new User("UserCreatedByCallback");
 
            }
 
        }).when(userService).findUserByName(Mockito.anyString());
 
    }
    
    @Test
    public void testArgumentMatcher() throws Exception {
 
        Mockito.when(userService.findUserByName(Mockito.<string>any())).thenReturn(Mockito.<user>any());
 
        userManager.findUser("user");
 
        //Verify if saveUser was invoked on userService with given 'user' object.
        Mockito.verify(userService).findUserByName("user");
 
        //Another example
        userManager.updateUser("user", new Date());
 
        Mockito.verify(userService).updateUser(Mockito.eq("user"), Mockito.<date>any());
    }
    
    @Test(expected = RuntimeException.class)
    public void testThrowException() throws Exception {

        //throw an exception on call to userService
        Mockito.doThrow(new RuntimeException()).when(userService).saveUser(Mockito.<User>any());

        //this will throw RunTime exception
        userManager.saveUser(Mockito.mock(User.class));

    }
    
}
