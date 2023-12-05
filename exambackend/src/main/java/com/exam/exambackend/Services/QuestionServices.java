package com.exam.exambackend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exam.exambackend.Model.Question;
import com.exam.exambackend.Model.Quizz;

@Service
public interface QuestionServices 
{
    public Question addQuestion(Question question);
    public Question updaQuestion(Question question);
    public List<Question> getquestion();
    public Question getsinglequestion(Long id);
    public void deletequestion(Long id);
    public List<Question> getquestionsofquizz(Quizz quizz);
    
}
