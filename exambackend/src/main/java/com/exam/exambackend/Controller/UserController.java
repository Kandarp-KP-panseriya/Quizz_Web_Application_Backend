package com.exam.exambackend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.exambackend.Model.User;
import com.exam.exambackend.Services.UserServices;

@RequestMapping("/user")
@RestController
@CrossOrigin("*")
public class UserController {
    
    @Autowired
    private UserServices us;
    @PostMapping("/")
    public User createuser(@RequestBody User user) throws Exception
    {
        User u = user;
        u.setRole("USER");
        return this.us.createuser(u);
    }

    @GetMapping("/")
    public List<User> showdata()
    {
        List<User> list =  us.showdata();
        return list;
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable ("username") String username)
    {
        return this.us.getuser(username);   
    }

    @DeleteMapping("/{userid}")
    public String deleteuser(@PathVariable("userid") Long userid)
    {
        return this.us.deleteuserbyid(userid);
   
    }
}
