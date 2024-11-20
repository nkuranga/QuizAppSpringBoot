package com.example.quizApp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    @ManyToMany
    private List<Questions> Questions;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQuestions(List<Questions> questions) {
        Questions = questions;
    }

    public List<Questions> getQuestions() {
        return Questions;
    }


}
