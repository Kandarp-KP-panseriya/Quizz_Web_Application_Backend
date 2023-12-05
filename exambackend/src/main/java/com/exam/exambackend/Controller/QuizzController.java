package com.exam.exambackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.exambackend.Model.Quizz;
import com.exam.exambackend.Services.QuizzServices;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizzController 
{
    @Autowired
    private QuizzServices quizzServices;   
    
    //add quiz
    @PostMapping("/")
    public ResponseEntity<Quizz> addquiz(@RequestBody Quizz quizz)
    {
        return ResponseEntity.ok(this.quizzServices.addquizz(quizz));
    }

    //update
    @PutMapping("/")
    public ResponseEntity<Quizz> updateq(@RequestBody Quizz quizz)
    {
        return ResponseEntity.ok(this.quizzServices.update(quizz));
    }

    //get all
    @GetMapping("/")
    public ResponseEntity<?> getallquiz()
    {
        return ResponseEntity.ok(this.quizzServices.getquizz());
    }
    
    @GetMapping("/{qid}")
    public Quizz getsingleqizz(@PathVariable ("qid") Long qid)
    {
        return this.quizzServices.getsinglequizz(qid);
    }

    @DeleteMapping("/{qid}")
    public String deleted(@PathVariable("qid") Long qid)
    {
        System.out.println("DEleted id:"+qid);
        String nm =  this.quizzServices.delete(qid);
        return nm;
    }
}
