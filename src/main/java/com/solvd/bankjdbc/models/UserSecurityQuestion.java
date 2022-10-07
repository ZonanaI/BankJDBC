package com.solvd.bankjdbc.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserSecurityQuestion  implements Comparable<UserSecurityQuestion> {
    @JsonProperty
    private int id;
    @JsonProperty
    private int userLoginId;
    @JsonProperty
    private int securityAnswerId;
    @JsonProperty
    private String securityQuestion;
    @JsonProperty
    private String securityAnswer;

    //Getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(int userLoginId) {
        this.userLoginId = userLoginId;
    }

    public int getSecurityAnswerId() {
        return securityAnswerId;
    }

    public void setSecurityAnswerId(int securityAnswerId) {
        this.securityAnswerId = securityAnswerId;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }
    @Override
    public int compareTo(UserSecurityQuestion other) {
        return Integer.compare(this.id,other.id);
    }
}
