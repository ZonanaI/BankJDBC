package com.solvd.bankjdbc.models;

import java.util.Set;

public class UsersLogin {

    private long id;
    private String username;
    private String password;
    private Set<UserSecurityQuestions> securityQuestionsSet;

    //Getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Set<UserSecurityQuestions> getSecurityQuestionsSet() {
        return securityQuestionsSet;
    }

    public void setSecurityQuestionsSet(Set<UserSecurityQuestions> securityQuestionsSet) {
        this.securityQuestionsSet = securityQuestionsSet;
    }
}
