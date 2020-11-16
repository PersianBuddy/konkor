package com.example.konkor.models;

public class QuestionStatistic {
    private int likeCount;
    private int correctAnswers;
    private int wrongAnswers;
    private int skippedAnswers;

    public QuestionStatistic(int likeCount, int correctAnswers, int wrongAnswers, int skippedAnswers) {
        this.likeCount = likeCount;
        this.correctAnswers = correctAnswers;
        this.wrongAnswers = wrongAnswers;
        this.skippedAnswers = skippedAnswers;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int getWrongAnswers() {
        return wrongAnswers;
    }

    public void setWrongAnswers(int wrongAnswers) {
        this.wrongAnswers = wrongAnswers;
    }

    public int getSkippedAnswers() {
        return skippedAnswers;
    }

    public void setSkippedAnswers(int skippedAnswers) {
        this.skippedAnswers = skippedAnswers;
    }
}
