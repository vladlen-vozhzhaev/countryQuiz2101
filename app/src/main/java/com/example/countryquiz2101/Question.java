package com.example.countryquiz2101;

public class Question {
    private int imageResId; // идентификатор ресурса изображения флага
    private int correctAnswer; // индентификатор строкового ресурса с ответом

    public Question(int imageResId, int correctAnswer) {
        this.imageResId = imageResId;
        this.correctAnswer = correctAnswer;
    }

    public int getImageResId() {
        return imageResId;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}