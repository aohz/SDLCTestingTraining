package com.junittesting.example2;

import java.util.Date;
 
public class UserManager {
    private UserService userService;
 
    public void saveUser(User user) {
        userService.saveUser(user);
    }
 
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
 
    public User findUser(String userName) {
        return userService.findUserByName(userName);
    }
 
    public Date getUserLastLogin(User user) {
        return user.getLoginDate();
    }
 
    public void updateUser(String user, Date lastLoginDate) {
        userService.updateUser(user, lastLoginDate);
    }
}
