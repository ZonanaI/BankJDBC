package com.solvd.bankjdbc.dto.json;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalSerializer extends JsonSerializer<BigDecimal> {
        @Override
        public void serialize(BigDecimal value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
            // put your desired money style here
            jgen.writeString(value.setScale(2, RoundingMode.HALF_UP).toString());
        }
}

