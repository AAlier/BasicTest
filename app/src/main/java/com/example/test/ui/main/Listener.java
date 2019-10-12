package com.example.test.ui.main;

import com.example.test.model.Answer;

import java.util.HashMap;

public interface Listener {
    HashMap<Integer, Integer> getAnswers();

    void onClickAnswer(int position, Answer answer);
}
