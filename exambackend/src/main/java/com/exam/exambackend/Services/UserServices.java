package com.exam.exambackend.Services;
import com.exam.exambackend.Model.User;

import java.util.List;

import org.springframework.stereotype.Controller;

@Controller
public interface UserServices 
{
     public User createuser(User user) throws Exception;

     public User getuser(String uname);

    public List<User> showdata();
    public String deleteuserbyid(Long uid);
}