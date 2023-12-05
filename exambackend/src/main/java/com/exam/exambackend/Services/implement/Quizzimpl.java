package com.exam.exambackend.Services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.exambackend.Model.Quizz;
import com.exam.exambackend.Repository.QuizzRepository;
import com.exam.exambackend.Services.QuizzServices;


@Service
public class Quizzimpl implements QuizzServices {


    @Autowired
    private QuizzRepository quizzRepository;

    @Override
    public Quizz addquizz(Quizz quizz) {

        return this.quizzRepository.save(quizz);
    }

    @Override
    public Quizz update(Quizz quizz) {

        return this.quizzRepository.save(quizz);
    }

    @Override
    public List<Quizz> getquizz() {
        List<Quizz> q = this.quizzRepository.findAll();
        return q;
    }

    @Override
    public Quizz getsinglequizz(Long id) {
        return this.quizzRepository.findById(id).get();
    }

    @Override
    public String delete(Long id) {
   
        Quizz q = new Quizz();
        q.setQid(id);
        this.quizzRepository.delete(q);
        return "deleted";
   
    }

}
