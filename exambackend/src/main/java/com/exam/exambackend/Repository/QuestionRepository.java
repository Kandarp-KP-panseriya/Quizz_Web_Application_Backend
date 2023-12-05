package com.exam.exambackend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.exambackend.Model.Question;
import com.exam.exambackend.Model.Quizz;

public interface QuestionRepository extends JpaRepository<Question,Long> {

    List<Question> findByQuizz(Quizz quizz);

    
}