package com.example.countryquiz2101;

import java.io.Serializable;

public class UserAnswer implements Serializable {
    private int question;
    private int correctAnswer;
    private boolean userAnswer;

    public UserAnswer(int question, int correctAnswer, boolean userAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.userAnswer = userAnswer;
    }

    public int getQuestion() {
        return question;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isUserAnswer() {
        return userAnswer;
    }
}
