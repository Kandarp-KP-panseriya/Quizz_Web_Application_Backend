package com.exam.exambackend.Services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.exambackend.Model.feedback;
import com.exam.exambackend.Repository.feedbackRepository;

@Service
public class feedbackimp
{
    @Autowired
    private feedbackRepository feedbackRepo;

    public List<feedback> getfedbackdata()
    {
        return this.feedbackRepo.findAll();
    }

    public feedback savefb(feedback fb)
    {
        return this.feedbackRepo.save(fb);
    }



}
