package com.exam.exambackend.Model;

import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categories
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Cid;

    private String Title;

    private String Description;

    @OneToMany(mappedBy = "categories",fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    //cycl. Redundancy  ayathi quess ne nyathi catagories no thai
    @JsonIgnore
    private Set<Quizz> quizzes = new LinkedHashSet<>();

    public Categories(Long cid, String title, String description) {
        Cid = cid;
        Title = title;
        Description = description;
    }

    public Categories() {
    }

    public Long getCid() {
        return Cid;
    }

    public void setCid(Long cid) {
        Cid = cid;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    
}