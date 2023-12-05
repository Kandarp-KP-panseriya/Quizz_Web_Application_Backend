package com.exam.exambackend.Services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.exambackend.Model.Question;
import com.exam.exambackend.Model.Quizz;
import com.exam.exambackend.Repository.QuestionRepository;
import com.exam.exambackend.Services.QuestionServices;

@Service
public class Questionimp implements QuestionServices
{
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question addQuestion(Question question) {
        return this.questionRepository.save(question);
       }

    @Override
    public Question updaQuestion(Question question) {
        return this.questionRepository.save(question);
      }

    @Override
    public List<Question> getquestion() {
        List<Question> l1 = this.questionRepository.findAll();
        return l1;
      }

    @Override
    public Question getsinglequestion(Long id) {
        return this.questionRepository.findById(id).get();
      }

    @Override
    public void deletequestion(Long id) {
        Question q = this.questionRepository.findById(id).get();
        this.questionRepository.delete(q);
        this.questionRepository.deleteById(id);
      }

    @Override
    public List<Question> getquestionsofquizz(Quizz quizz) {

        return this.questionRepository.findByQuizz(quizz);
      }
    
}
