package com.solvd.bankjdbc.models;

import java.util.Set;

public class UserLogin implements Comparable<UserLogin> {

    private int id;
    private String username;
    private String password;
    private Set<UserSecurityQuestion> securityQuestionsSet;

    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserSecurityQuestion> getSecurityQuestionsSet() {
        return securityQuestionsSet;
    }

    public void setSecurityQuestionsSet(Set<UserSecurityQuestion> securityQuestionsSet) {
        this.securityQuestionsSet = securityQuestionsSet;
    }

    @Override
    public int compareTo(UserLogin other) {
        return Integer.compare(this.id,other.id);
    }
}
