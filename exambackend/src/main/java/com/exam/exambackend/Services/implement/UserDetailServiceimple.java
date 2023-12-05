package com.exam.exambackend.Services.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exam.exambackend.Model.User;
import com.exam.exambackend.Repository.UserRepository;


@Service
public class UserDetailServiceimple implements UserDetailsService
{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        User user = this.userRepository.findByUsername(username);
        if(user == null)
        {
            System.out.println("User no found");
        }

        return user;
    }
    
}