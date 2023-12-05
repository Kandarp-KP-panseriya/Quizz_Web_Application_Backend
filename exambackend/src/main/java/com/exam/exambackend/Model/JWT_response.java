package com.exam.exambackend.Model;

import org.springframework.stereotype.Controller;

@Controller
public class JWT_response
{
    String token;
    public JWT_response() {
    }

    public JWT_response(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


  
    
}