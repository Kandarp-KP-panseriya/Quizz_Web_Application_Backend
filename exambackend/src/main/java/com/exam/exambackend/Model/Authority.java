package com.exam.exambackend.Model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;

@Controller
public class Authority implements GrantedAuthority
{

    private String authority;

    Authority(String authority)
    {
        this.authority = authority;
    }

    

    public Authority() {
    }



    @Override
    public String getAuthority()
    {
        return this.authority;
    }
    

}