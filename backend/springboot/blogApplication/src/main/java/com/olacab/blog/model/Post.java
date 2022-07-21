package com.olacab.blog.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document("posts")
public class Post {
    @Id
    private long postId;
    private long userId;
    private String title;
    private String content;

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
