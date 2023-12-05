package com.exam.exambackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.exambackend.Model.User;

public interface UserRepository extends JpaRepository<User, Long>
{
    
    public User findByUsername(String nm);

}
