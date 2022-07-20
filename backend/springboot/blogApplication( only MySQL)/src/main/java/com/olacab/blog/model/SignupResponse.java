package com.olacab.blog.model;

public class SignupResponse {
    private boolean signupStatus;
    private String message;

    public boolean isSignupStatus() {
        return signupStatus;
    }

    public void setSignupStatus(boolean signupStatus) {
        this.signupStatus = signupStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
