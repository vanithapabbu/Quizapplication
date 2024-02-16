package com.example.quizapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizapplication.entity.Question;
import com.example.quizapplication.service.QuestionSerice;

@RestController
@RequestMapping("/questions")
public class QuestionController {

	@Autowired
	QuestionSerice questionService;
	
	@PostMapping("/createQuestions")
	public ResponseEntity<String> createQuestion(@RequestBody Question question) {
		return questionService.createQuestion(question);
	}
	
	@GetMapping("/allQuestions")
	public ResponseEntity<List<Question>>  getAllQUestions() {
		return questionService.getAllQuestions();
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
		return questionService.getQuestionsByCategory(category);
	}
	
	
	
	
	
	
	
	
}
