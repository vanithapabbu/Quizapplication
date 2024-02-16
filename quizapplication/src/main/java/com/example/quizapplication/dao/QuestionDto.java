package com.example.quizapplication.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.quizapplication.entity.Question;

@Repository
public interface QuestionDto extends JpaRepository<Question, Integer> {

	List<Question> findByCategory(String category);

	@Query(value = " SELECT * FROM question q Where q.category = :category ORDER BY RAND() LIMIT :noOfQuestions",nativeQuery = true)
	List<Question> findRandomQuestionsByCategory(String category, int noOfQuestions);
}
