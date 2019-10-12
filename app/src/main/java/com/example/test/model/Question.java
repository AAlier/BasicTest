package com.example.test.model;

import java.util.List;

public class Question {
    private int id;
    private String title;
    private List<Answer> answers;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}
