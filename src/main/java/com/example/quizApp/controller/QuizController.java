package com.example.quizApp.controller;

import com.example.quizApp.model.QuestionWrapper;
import com.example.quizApp.model.Questions;
import com.example.quizApp.services.QuizServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizServices quizServices;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam Integer numberOfQuestions, @RequestParam String title){

        return quizServices.createQuiz(category,numberOfQuestions,title);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuestions(@PathVariable Integer id){
        return  quizServices.getQuestions(id);
    }
}
