package com.exam.exambackend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class feedback 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fid;
    private String comment;
    public Long getFid() {
        return fid;
    }
    public void setFid(Long fid) {
        this.fid = fid;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public feedback(Long fid, String comment) {
        this.fid = fid;
        this.comment = comment;
    }
    public feedback() {
    }

    
}
