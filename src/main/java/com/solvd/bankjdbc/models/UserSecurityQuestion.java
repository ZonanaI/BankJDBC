package com.solvd.bankjdbc.models;

public class UserSecurityQuestion  implements Comparable<UserSecurityQuestion> {
    private int id;
    private int userLoginId;
    private int securityAnswerId;
    private String securityQuestion;
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
