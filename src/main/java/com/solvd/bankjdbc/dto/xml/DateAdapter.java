package com.solvd.bankjdbc.dto.xml;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class DateAdapter extends XmlAdapter<String, LocalDate> {

    public DateTimeFormatter dateFormat() {

        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return new DateTimeFormatterBuilder()
                .appendOptional(pattern)
                .toFormatter();
    }

    @Override
    public LocalDate unmarshal(String s) {
        DateTimeFormatter formatter = dateFormat();
        return LocalDate.parse(s,formatter);
    }

    @Override
    public String marshal(LocalDate localDate) {
        return localDate.toString();
    }
}
