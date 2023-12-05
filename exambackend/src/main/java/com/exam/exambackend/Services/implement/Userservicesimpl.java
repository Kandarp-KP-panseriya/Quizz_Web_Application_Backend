package com.exam.exambackend.Services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.exambackend.Model.User;
import com.exam.exambackend.Repository.UserRepository;
import com.exam.exambackend.Services.UserServices;

@Service
public class Userservicesimpl implements UserServices
{

    @Autowired
    private UserRepository ur;

    @Override
    public User createuser(User user) throws Exception 
     {
       
         User local = this.ur.findByUsername(user.getUsername());
        if(local!=null)
        {
            System.out.println("User name selected");
            local = null;
            throw new Exception("User Already available");
        }
        else
        {

            local = this.ur.save(user);
            return local;
        }

    }


    //get data for display
    @Override
    public User getuser(String uname) {
    
        User local = this.ur.findByUsername(uname);
        return local;
    }

    public String deleteuserbyid(Long uid)
    {
        this.ur.deleteById(uid);
        return "deleted ok";
    }


    @Override
    public List<User> showdata() 
    {
        return ur.findAll();
    }


    
}
