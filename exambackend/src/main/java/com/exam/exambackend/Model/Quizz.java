package com.exam.exambackend.Model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Quizz {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Qid;

    private String Quezz_Title;

    private String Quezz_Description;

    private String mxaMarks;

    private String numberofQuestions;

    private boolean active=false;

    @ManyToOne(fetch = FetchType.EAGER)
    private Categories categories;


    @OneToMany(mappedBy = "quizz",fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JsonIgnore
    private Set<Question> question = new HashSet<>();


    

    public Quizz() {
    }


    public Long getQid() {
        return Qid;
    }


    public Quizz(Long qid, String quezz_Title, String quezz_Description, String mxaMarks, String numberofQuestions,
            boolean active, Categories categories, Set<Question> question) {
        Qid = qid;
        Quezz_Title = quezz_Title;
        Quezz_Description = quezz_Description;
        this.mxaMarks = mxaMarks;
        this.numberofQuestions = numberofQuestions;
        this.active = active;
        this.categories = categories;
        this.question = question;
    }


    public void setQid(Long qid) {
        Qid = qid;
    }


    public String getQuezz_Title() {
        return Quezz_Title;
    }


    public void setQuezz_Title(String quezz_Title) {
        Quezz_Title = quezz_Title;
    }


    public String getQuezz_Description() {
        return Quezz_Description;
    }


    public void setQuezz_Description(String quezz_Description) {
        Quezz_Description = quezz_Description;
    }


    public String getMxaMarks() {
        return mxaMarks;
    }


    public void setMxaMarks(String mxaMarks) {
        this.mxaMarks = mxaMarks;
    }


    public String getNumberofQuestions() {
        return numberofQuestions;
    }


    public void setNumberofQuestions(String numberofQuestions) {
        this.numberofQuestions = numberofQuestions;
    }


    public boolean isActive() {
        return active;
    }


    public void setActive(boolean active) {
        this.active = active;
    }


    public Categories getCategories() {
        return categories;
    }


    public void setCategories(Categories categories) {
        this.categories = categories;
    }


    public Set<Question> getQuestion() {
        return question;
    }


    public void setQuestion(Set<Question> question) {
        this.question = question;
    }

   
    
}