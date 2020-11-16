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
}
