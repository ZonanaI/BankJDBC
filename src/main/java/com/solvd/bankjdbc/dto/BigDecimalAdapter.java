package com.solvd.bankjdbc.dto;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class BigDecimalAdapter extends XmlAdapter<String, BigDecimal> {

    @Override
    public String marshal(BigDecimal v) {
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols();
        otherSymbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("#0.00",otherSymbols);
        return df.format(v);
    }

    @Override
    public BigDecimal unmarshal(String v) {
        double d = Double.parseDouble(v);
        return BigDecimal.valueOf(d);
    }

}