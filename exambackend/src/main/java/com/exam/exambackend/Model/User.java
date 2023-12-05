package com.exam.exambackend.Model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class User implements UserDetails
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    private String phone;
    private boolean enabled = true;
    private String profile;
    //user delete thid to user role pan delete, mappedby this biju table no baje maping ma jem bantu em,user fetch thai to eno role pan automatic match thai

    private String role;
    
    
    public User() {
    }



    
    public User(Long id, String username, String password, String firstName, String lastName, String email,
            String phone, boolean enabled, String profile, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.enabled = enabled;
        this.profile = profile;
        this.role = role;
    }


        public String getRole() {
        return role;
    }




    public void setRole(String role) {
        this.role = role;
    }




    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
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


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


    public boolean isEnabled() {
        return enabled;
    }


    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    public String getProfile() {
        return profile;
    }


    public void setProfile(String profile) {
        this.profile = profile;
    }






    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       /* Set<Authority> at = new HashSet<>();
        at.addAll(at);
        */
        return null;
    }




    @Override
    public boolean isAccountNonExpired() {
        return true;
     }




    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }




    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }
}