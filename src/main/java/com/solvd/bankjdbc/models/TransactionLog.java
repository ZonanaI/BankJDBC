package com.solvd.bankjdbc.models;

import com.solvd.bankjdbc.dto.xml.BigDecimalAdapter;
import com.solvd.bankjdbc.dto.xml.DateTimeAdapter;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@XmlRootElement(name = "transactionLog")
@XmlType(propOrder = {"id","employeeId","accountId","transactionTypeId","transactionDate","transactionAmount",
        "newBalance","employee"})
@XmlAccessorType(XmlAccessType.FIELD)
public class TransactionLog implements Comparable<TransactionLog> {

    @XmlAttribute
    private int id;
    private int employeeId;
    private int accountId;
    private int transactionTypeId;
    @XmlJavaTypeAdapter(DateTimeAdapter.class)
    private LocalDateTime transactionDate;
    @XmlJavaTypeAdapter(BigDecimalAdapter.class)
    private BigDecimal transactionAmount;
    @XmlJavaTypeAdapter(BigDecimalAdapter.class)
    private BigDecimal newBalance;
    @XmlElement (name = "employee")
    private Employee employee;
    @XmlTransient
    private Account account;
    @XmlTransient
    private TransactionType transactionType;

    //Getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(int transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public BigDecimal getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(BigDecimal newBalance) {
        this.newBalance = newBalance;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public int compareTo(TransactionLog other) {
        return Integer.compare(this.id,other.id);
    }

    @Override
    public String toString() {
        StringBuilder accountStringBuilder = new StringBuilder();
        accountStringBuilder.append(" account number: ").append(account.getAccountNumber());
        StringBuilder employeeStringBuilder = new StringBuilder();
        if(employee!=null){
            employeeStringBuilder.append(" employee name: ").append(employee.getFirstName()).append(" ")
                    .append(employee.getLastName());
        }
        else {
            employeeStringBuilder.append(" ");
        }
        return "TransactionLog{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", accountId=" + accountId +
                ", transactionTypeId=" + transactionTypeId +
                ", transactionDate=" + transactionDate +
                ", transactionAmount=" + transactionAmount +
                ", newBalance=" + newBalance +
                ", employee=" + employeeStringBuilder +
                ", account=" + accountStringBuilder +
                ", transactionType=" + transactionType +
                '}';
    }
}
