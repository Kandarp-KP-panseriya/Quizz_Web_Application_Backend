package com.exam.exambackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.exambackend.Model.Quizz;

public interface QuizzRepository extends JpaRepository<Quizz,Long>  {

    
} 