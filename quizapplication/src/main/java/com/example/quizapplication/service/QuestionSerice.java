  package com.example.quizapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.quizapplication.dao.QuestionDto;
import com.example.quizapplication.entity.Question;

@Service
public class QuestionSerice {

	@Autowired
	QuestionDto questionDto;
	
	//Store Questions
	public ResponseEntity<String> createQuestion(Question question) {
		questionDto.save(question);
		return  new ResponseEntity<> ("Question added successfully" , HttpStatus.CREATED);
	}
	
	
	//Getting all Questions
	public ResponseEntity<List<Question>> getAllQuestions(){
		try {
		return new ResponseEntity<>(questionDto.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}
	
	
	//Getting Questions by category
	public ResponseEntity<List<Question>> getQuestionsByCategory(String category){
		try {
		return new ResponseEntity<> (questionDto.findByCategory(category), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<> (new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	
}
