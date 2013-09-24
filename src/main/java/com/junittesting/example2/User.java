package com.junittesting.example2;

import java.util.Date;
 
public class User {
 
    private String userName;
 
    private Date loginDate;
 
    public User(String userName) {
        this.userName = userName;
    }
 
    public User(String userName, Date loginDate) {
        this.userName = userName;
        this.loginDate = loginDate;
    }
 
    public String getUserName() {
        return userName;
    }
 
    public void setUserName(String userName) {
        this.userName = userName;
    }
 
    public Date getLoginDate() {
        return loginDate;
    }
 
    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
} 