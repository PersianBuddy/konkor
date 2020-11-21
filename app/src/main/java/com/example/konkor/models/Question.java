package com.example.konkor.models;

import java.util.ArrayList;

public class Question {
    private String question;
    private String [] answers;
    private int correctAnswerIndex;
    private QuestionStatistic statistics;
    private ArrayList <String> comments;

    public Question(String question, String[] answers, int correctAnswerIndex, QuestionStatistic statistics, ArrayList<String> comments) {
        this.question = question;
        this.answers = answers;
        this.correctAnswerIndex = correctAnswerIndex;
        this.statistics = statistics;
        this.comments = comments;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public void setCorrectAnswerIndex(int correctAnswerIndex) {
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public QuestionStatistic getStatistics() {
        return statistics;
    }

    public void setStatistics(QuestionStatistic statistics) {
        this.statistics = statistics;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }
}
