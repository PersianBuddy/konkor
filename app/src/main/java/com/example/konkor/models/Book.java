package com.example.konkor.models;

public class Book {
    private int id;
    private String title;
    private String author;
    private int credit;

    public Book(int id, String title, String author, int credit) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.credit = credit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
