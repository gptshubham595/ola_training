package com.olacab.blog.model;

public class ArticleResponse {
    private boolean isArticleAdded;
    private String message;
    public boolean isArticleAdded() {
        return isArticleAdded;
    }

    public void setArticleAdded(boolean articleAdded) {
        isArticleAdded = articleAdded;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
