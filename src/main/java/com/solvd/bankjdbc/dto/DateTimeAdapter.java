package com.solvd.bankjdbc.dto;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class DateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

    public DateTimeFormatter dateFormat() {

        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return new DateTimeFormatterBuilder()
                .appendOptional(pattern)
                .toFormatter();
    }

    @Override
    public LocalDateTime unmarshal(String s) {
        DateTimeFormatter formatter = dateFormat();
        return LocalDateTime.parse(s,formatter);
    }

    @Override
    public String marshal(LocalDateTime localDate) {
        return localDate.toString();
    }
}
