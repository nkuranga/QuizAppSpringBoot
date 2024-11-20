package com.example.quizApp.model;

import lombok.Data;

@Data
public class QuestionWrapper {
    private  Integer id;
    private  String questions;
    private String category;
    private String option1;
    private String option2;

    public QuestionWrapper(Integer id, String questions, String category, String option1, String option2){
        this.id = id;
        this.questions = questions;
        this.category = category;
        this.option1 = option1;
        this.option2 = option2;
    }
}
