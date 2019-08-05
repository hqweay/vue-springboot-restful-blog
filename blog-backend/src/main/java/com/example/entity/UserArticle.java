package com.example.entity;

import java.io.Serializable;

public class UserArticle implements Serializable {
    private String userEmail;

    private Long articleId;

    private static final long serialVersionUID = 1L;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }
}