package com.example.quizApp.controller;

import com.example.quizApp.model.Questions;
import com.example.quizApp.services.QuestionsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {
    @Autowired
    QuestionsServices questionsServices;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Questions>> getAllQuestions(){
        return questionsServices.getAllQuestions();

    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Questions>> getQuestionByCategory(@PathVariable String category){
        return questionsServices.getQuestionByCategory(category);
    }
    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Questions questions){
        return questionsServices.addQuestion(questions);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Integer id){
        return questionsServices.deleteQuestion(id);
    }

}
