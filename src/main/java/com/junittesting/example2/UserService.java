package com.junittesting.example2;


import java.util.Date;
 
public class UserService {
 
    public void saveUser(User user) {
        //Save user
        System.out.println("Saving user " + user);
    }
 
    public User findUserByName(String userName) {
        return new User(userName);
    }
 
    public void updateUser(String user, Date lastLoginDate) {
        //Update user
        System.out.println("Update user " + user);
    }
}