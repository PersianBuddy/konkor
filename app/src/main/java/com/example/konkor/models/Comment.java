package com.example.konkor.models;

public class Comment {
    private String comment;
    private int commentOwnerId;
    private int commentType;//question comment or comment comment

    public Comment(String comment, int commentOwnerId, int commentType) {
        this.comment = comment;
        this.commentOwnerId = commentOwnerId;
        this.commentType = commentType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getCommentOwnerId() {
        return commentOwnerId;
    }

    public void setCommentOwnerId(int commentOwnerId) {
        this.commentOwnerId = commentOwnerId;
    }

    public int getCommentType() {
        return commentType;
    }

    public void setCommentType(int commentType) {
        this.commentType = commentType;
    }
}
