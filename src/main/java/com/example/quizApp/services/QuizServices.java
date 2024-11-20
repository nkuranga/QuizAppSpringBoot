package com.example.quizApp.services;

import com.example.quizApp.dao.QuestionsDao;
import com.example.quizApp.dao.QuizDao;
import com.example.quizApp.model.QuestionWrapper;
import com.example.quizApp.model.Questions;
import com.example.quizApp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServices {

    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionsDao questionsDao;
    public ResponseEntity<String> createQuiz(String category, Integer numberOfQuestions, String title) {
        List<Questions> questions = questionsDao.getRandomQuestions(numberOfQuestions, category);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
      quizDao.save(quiz);
      return new ResponseEntity<>(StatusMessage.QUIZ_SUCCESS_MSG.label,HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Questions> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser = new ArrayList<>();
        for(Questions q: questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestions(),q.getOption1(), q.getOption2(), q.getCategory());
            questionForUser.add(qw);
        }
        return new ResponseEntity<>(questionForUser, HttpStatus.OK);
    }
}
