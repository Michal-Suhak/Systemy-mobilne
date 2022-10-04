package com.example.quiz_app;

public class Question {
    private int questionId;
    private boolean trueAnswer;

    public Question(int questionId, boolean trueAnswer) {
        this.questionId = questionId;
        this.trueAnswer = trueAnswer;
    }

    public boolean isTrueAnswer() {
        return this.trueAnswer;
    }

    public int getQuestionId() {
        return this.questionId;
    }
}
