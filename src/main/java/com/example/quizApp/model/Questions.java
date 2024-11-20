package com.example.quizApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Questions {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;
    private  String questions;
    private String category;
    private String option1;
    private String option2;
    private String answer;

    public Integer getId() {
        return id;
    }

    public String getQuestions() {
        return questions;
    }

    public String getCategory() {
        return category;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }
    public String getAnswer() {
        return answer;
    }
}
