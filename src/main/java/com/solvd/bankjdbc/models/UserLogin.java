package com.solvd.bankjdbc.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.*;

import java.util.Set;

@XmlRootElement(name = "userLogin")
@XmlType(propOrder = {"id","userNameId","username","password","securityQuestionsSet"})
@XmlAccessorType(XmlAccessType.FIELD)

public class UserLogin implements Comparable<UserLogin> {

    @XmlAttribute
    @JsonProperty
    private int id;
    @JsonProperty
    private int userNameId;
    @JsonProperty
    private String username;
    @JsonProperty
    private String password;
    @XmlElement(name = "securityQuestions")
    @JsonProperty
    private Set<UserSecurityQuestion> securityQuestionsSet;
    @XmlTransient
    private Set<Account> accountSet;

    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserNameId() {
        return userNameId;
    }

    public void setUserNameId(int userNameId) {
        this.userNameId = userNameId;
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

    public Set<Account> getAccountSet() {
        return accountSet;
    }

    public void setAccountSet(Set<Account> accountSet) {
        this.accountSet = accountSet;
    }

    @Override
    public int compareTo(UserLogin other) {
        return Integer.compare(this.id,other.id);
    }

    @Override
    public String toString() {
        StringBuilder secQuestionStringBuilder = new StringBuilder();
        getSecurityQuestionsSet().forEach(t-> secQuestionStringBuilder.append(" security question: ")
                .append(t.getSecurityQuestion()).append(" security answer: ").append(t.getSecurityAnswer()).append(", "));
        StringBuilder accountStringBuilder = new StringBuilder();
        if (accountSet != null){
            getAccountSet().forEach(t -> accountStringBuilder.append(" account number: ").append(t.getAccountNumber()));
        }
        return "UserLogin{" +
                "id=" + id +
                ", userNameId=" + userNameId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' + "\n" +
                ", securityQuestionsSet=" + secQuestionStringBuilder +
                ", accountSet=" + accountStringBuilder +
                '}';
    }
}
