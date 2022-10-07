package com.solvd.bankjdbc.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.solvd.bankjdbc.dto.json.BigDecimalDeserializer;
import com.solvd.bankjdbc.dto.json.BigDecimalSerializer;
import com.solvd.bankjdbc.dto.json.LocalDateDeserializer;
import com.solvd.bankjdbc.dto.json.LocalDateSerializer;
import com.solvd.bankjdbc.dto.xml.BigDecimalAdapter;
import com.solvd.bankjdbc.dto.xml.DateAdapter;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.math.BigDecimal;
import java.time.LocalDate;

@XmlRootElement(name = "fixedTermDeposit")
@XmlType(propOrder = {"id","accountId","amount","rate","fromDate"})
@XmlAccessorType(XmlAccessType.FIELD)
public class FixedTermDeposit implements Comparable <FixedTermDeposit> {
    @XmlAttribute
    @JsonProperty
    private int id;
    @JsonProperty
    private int accountId;
    @XmlJavaTypeAdapter(BigDecimalAdapter.class)
    @JsonProperty
    @JsonDeserialize(using = BigDecimalDeserializer.class)
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal amount;
    @XmlJavaTypeAdapter(BigDecimalAdapter.class)
    @JsonProperty
    @JsonDeserialize(using = BigDecimalDeserializer.class)
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal rate;
    @XmlJavaTypeAdapter(DateAdapter.class)
    @JsonProperty
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate fromDate;

    //Getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }
    @Override
    public int compareTo(FixedTermDeposit other) {
        return Integer.compare(this.id,other.id);
    }

    @Override
    public String toString() {
        return "FixedTermDeposit{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", amount=" + amount +
                ", rate=" + rate +
                ", fromDate=" + fromDate +
                '}';
    }
}
