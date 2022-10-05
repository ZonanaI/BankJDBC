package com.solvd.bankjdbc.models;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "employee")
@XmlType(propOrder = {"id","firstName","lastName"})
@XmlAccessorType (XmlAccessType.FIELD)
public class Employee {

    @XmlAttribute
    private int id;

    private String firstName;

    private String lastName;

    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
