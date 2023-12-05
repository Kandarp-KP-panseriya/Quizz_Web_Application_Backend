package com.exam.exambackend.Model;

import org.springframework.stereotype.Controller;

@Controller
public class JWT_request
{
    String username;
    String password;
    
    public JWT_request() {
    }
    public JWT_request(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    

}