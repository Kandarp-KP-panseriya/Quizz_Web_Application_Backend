package com.exam.exambackend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.exambackend.Model.feedback;
import com.exam.exambackend.Services.implement.feedbackimp;

@RestController
@RequestMapping("/feedback")
@CrossOrigin("*")
public class feedbackController
{
    @Autowired
    private feedbackimp fbi;
    
    @GetMapping("/")
    public List<feedback> getfeedback()
    {
        return this.fbi.getfedbackdata();
    }

    @PostMapping("/")
    public feedback savefeedback(@RequestBody feedback fb)
    {
        return this.fbi.savefb(fb);
    }
}
