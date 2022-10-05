package com.solvd.bankjdbc.models;

import jakarta.xml.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Set;


@XmlRootElement(name = "account")
@XmlType(propOrder = {"id","accountTypeID","accountStatusID","accountNumberID","balance","accountType","accountStatus",
        "accountNumber","customerSet","userLoginSet","cardSet","loanSet","fixedTermDepositSet",
        "transactionLogSet"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Account implements Comparable<Account>{
    @XmlAttribute
    private int id;
    private int accountTypeID;
    private int accountStatusID;
    private int accountNumberID;
    private BigDecimal balance;
    private String accountType;
    private String accountStatus;
    private String accountNumber;
    @XmlElement (name = "customer")
    private Set<Customer> customerSet;
    @XmlElement (name = "userLogin")
    private Set<UserLogin> userLoginSet;
    @XmlElement (name = "card")
    private Set<Card> cardSet;
    @XmlElement (name = "loan")
    private Set<Loan> loanSet;
    @XmlElement (name = "fixedTermDeposit")
    private Set<FixedTermDeposit> fixedTermDepositSet;
    //Getters and setters
    @XmlElement (name = "transactionLog")
    private Set<TransactionLog> transactionLogSet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountTypeID() {
        return accountTypeID;
    }

    public void setAccountTypeID(int accountTypeID) {
        this.accountTypeID = accountTypeID;
    }

    public int getAccountStatusID() {
        return accountStatusID;
    }

    public void setAccountStatusID(int accountStatusID) {
        this.accountStatusID = accountStatusID;
    }

    public int getAccountNumberID() {
        return accountNumberID;
    }

    public void setAccountNumberID(int accountNumberID) {
        this.accountNumberID = accountNumberID;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Set<Customer> getCustomerSet() {
        return customerSet;
    }

    public void setCustomerSet(Set<Customer> customerSet) {
        this.customerSet = customerSet;
    }

    public Set<UserLogin> getUserLoginSet() {
        return userLoginSet;
    }

    public void setUserLoginSet(Set<UserLogin> userLoginSet) {
        this.userLoginSet = userLoginSet;
    }

    public Set<Card> getCardSet() {
        return cardSet;
    }

    public void setCardSet(Set<Card> cardSet) {
        this.cardSet = cardSet;
    }

    public Set<Loan> getLoanSet() {
        return loanSet;
    }

    public void setLoanSet(Set<Loan> loanSet) {
        this.loanSet = loanSet;
    }

    public Set<FixedTermDeposit> getFixedTermDepositSet() {
        return fixedTermDepositSet;
    }

    public void setFixedTermDepositSet(Set<FixedTermDeposit> fixedTermDepositSet) {
        this.fixedTermDepositSet = fixedTermDepositSet;
    }

    public Set<TransactionLog> getTransactionLogSet() {
        return transactionLogSet;
    }

    public void setTransactionLogSet(Set<TransactionLog> transactionLogSet) {
        this.transactionLogSet = transactionLogSet;
    }

    @Override
    public String toString() {
        StringBuilder customerStringBuilder = new StringBuilder();
        getCustomerSet().forEach(t -> customerStringBuilder.append(" Full name: ").append(t.getFirstName()).append(" ")
                .append(t.getLastName()).append(", "));
        StringBuilder userLoginStringBuilder = new StringBuilder();
        getUserLoginSet().forEach(t -> userLoginStringBuilder.append(" user name: ")
                .append(t.getUsername()).append(", "));
        StringBuilder cardStringBuilder = new StringBuilder();
        getCardSet().forEach(t -> cardStringBuilder.append(" card number: ").append(t.getCardNumber()).append(" type: ")
                .append(t.getCardType()).append(", "));
        StringBuilder loanStringBuilder = new StringBuilder();
        getLoanSet().forEach(t -> loanStringBuilder.append(" amount: ").append(t.getAmount()).append(" rate: ")
                .append(t.getRate()).append(" returned amount: ").append(t.getReturnedAmount()).append(" from: ")
                .append(t.getFromDate()).append(", "));
        StringBuilder fixedTermDepositStringBuilder = new StringBuilder();
        getFixedTermDepositSet().forEach(t -> fixedTermDepositStringBuilder.append(" amount: ").append(t.getAmount())
                .append(" rate: ").append(t.getRate()).append(" from: ").append(t.getFromDate()).append(", "));



        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", accountType='" + accountType + '\'' +
                ", accountStatus='" + accountStatus + '\'' +
                ", accountNumber='" + accountNumber + '\'' + "\n" +
                ", customerSet=" + customerStringBuilder + "\n" +
                ", userLoginSet=" + userLoginStringBuilder + "\n" +
                ", cardSet=" + cardStringBuilder + "\n" +
                ", loanSet=" + loanStringBuilder + "\n" +
                ", fixedTermDepositSet=" + fixedTermDepositStringBuilder + "\n" +
                '}';
    }

    @Override
    public int compareTo(Account other) {
        return Integer.compare(this.id,other.id);
    }
}
