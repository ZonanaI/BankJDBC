package com.solvd.bankjdbc.models;


import java.util.Set;

public class Customer implements Comparable <Customer> {
    private int id;
    private Set<Integer> accountIds;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String phone;
    private Set<Account> accountSet;

    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Integer> getAccountIds() {
        return accountIds;
    }

    public void setAccountIds(Set<Integer> accountIds) {
        this.accountIds = accountIds;
    }

    public Set<Account> getAccountSet() {
        return accountSet;
    }

    public void setAccountSet(Set<Account> accountSet) {
        this.accountSet = accountSet;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Account> getAccountsSet() {
        return accountSet;
    }

    public void setAccountsSet(Set<Account> accountSet) {
        this.accountSet = accountSet;
    }

    @Override
    public int compareTo(Customer other) {
        return Integer.compare(this.id,other.id);
    }
}
