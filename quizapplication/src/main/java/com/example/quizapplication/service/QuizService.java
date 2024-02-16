package com.example.quizapplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.quizapplication.dao.QuestionDto;
import com.example.quizapplication.dao.QuizDto;
import com.example.quizapplication.entity.Question;
import com.example.quizapplication.entity.QuestionWrapper;
import com.example.quizapplication.entity.Quiz;
import com.example.quizapplication.entity.Response;

@Service
public class QuizService {

	@Autowired
	QuizDto quizDto;
	
	@Autowired
	QuestionDto questionDto;
	

	public ResponseEntity<String> createQuiz(String category, int noOfQuestions, String title) {
		
		List<Question> questions = questionDto.findRandomQuestionsByCategory(category,noOfQuestions);
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDto.save(quiz);
		
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}


	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		Optional<Quiz> quiz = quizDto.findById(id);
		List<Question> questionsFromDB = quiz.get().getQuestions();
		List<QuestionWrapper> questionsForUser = new ArrayList<>();
		for(Question q : questionsFromDB) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			questionsForUser.add(qw);
		}
		
		return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
	}


	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		Quiz quiz = quizDto.findById(id).get();
		List<Question> questions = quiz.getQuestions();
		int right = 0;
		int i = 0;
		for(Response response : responses) {
			if(response.getResponse().equals(questions.get(i).getRightAnswer()))
				right++;
			
			
			i++;
		}
		return new ResponseEntity<>(right , HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
}
