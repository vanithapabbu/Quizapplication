package com.example.quizapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.quizapplication.entity.Quiz;

@Repository
public interface QuizDto  extends JpaRepository<Quiz, Integer>{

}
