package com.solvd.bankjdbc.dto.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.math.BigDecimal;

public class BigDecimalDeserializer extends JsonDeserializer<BigDecimal> {

    @Override
    public BigDecimal deserialize(JsonParser jp, DeserializationContext context)
            throws IOException {
        return jp.getText() != null ? new BigDecimal(jp.getText()) : null;
    }
}