package com.solvd.bankjdbc.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.*;

import java.util.Set;
import java.util.TreeSet;

@XmlRootElement(name = "customer")
@XmlType(propOrder = {"id","firstName","lastName","address","city","state","phone"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer implements Comparable <Customer> {
    @XmlAttribute
    @JsonProperty
    private int id;
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String lastName;
    @JsonProperty
    private String address;
    @JsonProperty
    private String city;
    @JsonProperty
    private String state;
    @JsonProperty
    private String phone;

    @XmlTransient
    private Set<Account> accountSet = new TreeSet<>();

    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!getAccountSet().isEmpty()){
            getAccountSet().forEach(t -> stringBuilder.append(" account number: ").append(t.getAccountNumber())
                    .append(", "));
        }

        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", phone='" + phone + "\n" +
                ", accountSet=" + stringBuilder +
                '}';
    }

    @Override
    public int compareTo(Customer other) {
        return Integer.compare(this.id,other.id);
    }
}
