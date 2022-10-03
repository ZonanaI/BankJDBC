package com.solvd.bankjdbc.models;

import java.time.LocalDate;

public class Card implements Comparable <Card> {
    private int id;
    private int cardNumberId;
    private int cardTypeId;
    private int accountId;
    private LocalDate expDate;
    private String securityNumber;
    private String cardNumber;
    private String cardType;

    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCardNumberId() {
        return cardNumberId;
    }

    public void setCardNumberId(int cardNumberId) {
        this.cardNumberId = cardNumberId;
    }

    public int getCardTypeId() {
        return cardTypeId;
    }

    public void setCardTypeId(int cardTypeId) {
        this.cardTypeId = cardTypeId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public String getSecurityNumber() {
        return securityNumber;
    }

    public void setSecurityNumber(String securityNumber) {
        this.securityNumber = securityNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", expDate=" + expDate +
                ", securityNumber='" + securityNumber + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardType='" + cardType + '\'' +
                '}';
    }

    @Override
    public int compareTo(Card other) {
        return Integer.compare(this.id, other.id);
    }
}
