package com.example.quizApp.services;

public enum StatusMessage {
    SUCCESS("Question added Successfully"),
    ERROR("Error"),
    QUIZ_SUCCESS_MSG("Quiz Created Successfully"),
    DELETE("Question Deleted Successfully");

    public final String label;
    private StatusMessage(String label){
        this.label = label;
    }
}
