package com.olacabs.social.model;

public class PostRequestData {
    private String username;
    private String description;

    public String toString() {
        return username + " " + description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
