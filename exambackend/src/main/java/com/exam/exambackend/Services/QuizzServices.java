package com.exam.exambackend.Services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.exam.exambackend.Model.Quizz;

@Service
public interface QuizzServices
{

    public Quizz addquizz(Quizz quizz);
    public Quizz update(Quizz quizz);
    public List<Quizz> getquizz();        
    public Quizz getsinglequizz(Long id);
    public String delete(Long id);
}